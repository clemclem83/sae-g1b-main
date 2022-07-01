package fr.univ_amu.iut.DAO.JPA;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.entity.Etudiant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOEtudiantJPA implements DAOEtudiant {
    private final EntityManager entityManager;

    public DAOEtudiantJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Etudiant insert(Etudiant etudiant) {
        entityManager.getTransaction().begin();
        entityManager.persist(etudiant);
        entityManager.getTransaction().commit();

        return entityManager.find(Etudiant.class, etudiant.getNumEt());
    }

    public boolean update(Etudiant obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Etudiant obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Etudiant> findAll() {
        TypedQuery<Etudiant> query = entityManager.createNamedQuery("Etudiant.findAll", Etudiant.class);
        return query.getResultList();
    }

    public Etudiant getById(Integer id) {
        TypedQuery<Etudiant> query = entityManager.createNamedQuery("Etudiant.findById", Etudiant.class);
        query.setParameter("numEt", id);
        return query.getSingleResult();
    }

    public List<Etudiant> findByAnnee(int annee) {
        return null;
    }

    public List<Etudiant> findByGroupe(int groupe) {
        return null;
    }

    public List<Etudiant> findByNom(String nomEt) {
        return null;
    }
    public int computeNbEtudiant() {
        return 0;
    }
}

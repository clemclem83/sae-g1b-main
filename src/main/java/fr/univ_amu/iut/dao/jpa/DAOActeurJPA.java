package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOActeur;
import fr.univ_amu.iut.model.Acteur;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOActeurJPA extends DAOJPAImpl implements DAOActeur {
    public DAOActeurJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Acteur obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public List<Acteur> findByPrenom(String prenom){
        return null;
    }

    @Override
    public List<Acteur> findAll() {
        return super.findImpl(Acteur.class, "Acteur.findAll");
    }

    @Override
    public Acteur getById(Integer id) {
        return super.getByIdImpl(Acteur.class, id);
    }

    @Override
    public Acteur insert(Acteur obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Acteur obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Acteur> findByNom(String nom) {
        return super.findByImpl(Acteur.class, "Acteur.findByNom", "nom", nom);
    }
}

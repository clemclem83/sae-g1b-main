package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.TypeRessource;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class DAOUsageJPA extends DAOJPAImpl implements DAOUsage {
    public DAOUsageJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Usage obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usage> findAll() {
        return super.findImpl(Usage.class, "Usage.findAll");
    }

    @Override
    public Usage getById(Integer id) {
        return super.getByIdImpl(Usage.class, id);
    }

    @Override
    public Usage insert(Usage obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Usage obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usage> findByNom(String nom) {
        return super.findByImpl(Usage.class, "Usage.findByNom", "nom", nom);
    }

    @Override
    public List<Usage> findByDescription(String description){
        return super.findByImpl(Usage.class, "Usage.findByDescription", "description", description);
    }

    @Override
    public List<Usage> findByCommentaire(String commentaire){
        return super.findByImpl(Usage.class, "Usage.findByCommentaire", "commentaire", commentaire);
    }

    @Override
    public List<Usage> findByAcademie(Academie academie){
        //TO DO DECOMMENTER CA UNE FOIS QU'ON A UNE BDD AVEC DES DONNEES
        /*
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByAcademie",Usage.class);
        query.setParameter("academie",academie);
        return  query.getResultList();
         */
        List<Usage> usages = new ArrayList<>();
        for (int i = 0; i < 24; i++){
            Usage usage = new Usage();
            usage.setCommentaire("je suis l'usage numero %s et je suis tres pertinant :)".formatted(i));
            usages.add(usage);
        }
        return usages;
    }


}

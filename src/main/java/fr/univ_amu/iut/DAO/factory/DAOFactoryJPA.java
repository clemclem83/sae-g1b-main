package fr.univ_amu.iut.DAO.factory;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JPA.DAOEtudiantJPA;
import fr.univ_amu.iut.DAO.JPA.DAOModuleJPA;
import fr.univ_amu.iut.DAO.JPA.DAOProfJPA;
import fr.univ_amu.iut.DAO.factory.DAOFactory;
import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOFactoryJPA implements DAOFactory {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestionPedaPU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public DAOFactoryJPA(){
    }
    @Override
    public DAOEtudiant createDAOEtudiant() {
        return new DAOEtudiantJPA(getEntityManager());
    }

    @Override
    public DAOProf createDAOProf() {
        return new DAOProfJPA(getEntityManager());
    }

    @Override
    public DAOModule createDAOModule() {
        return new DAOModuleJPA(getEntityManager());
    }
}

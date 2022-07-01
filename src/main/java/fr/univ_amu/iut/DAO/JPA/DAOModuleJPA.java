package fr.univ_amu.iut.DAO.JPA;

import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOModuleJPA implements DAOModule {

    private final EntityManager entityManager;
    public DAOModuleJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public boolean delete(Module obj) {
        return false;
    }

    @Override
    public List<Module> findAll() {
        return null;
    }

    @Override
    public Module getById(String id) {
        return null;
    }

    @Override
    public Module insert(Module obj) {
        return null;
    }

    @Override
    public boolean update(Module obj) {
        return false;
    }

    @Override
    public List<Module> findByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Module> findByDiscipline(String discipline) {
        return null;
    }

    @Override
    public List<Module> findByResponsable(Prof Responsable) {
        return null;
    }
}

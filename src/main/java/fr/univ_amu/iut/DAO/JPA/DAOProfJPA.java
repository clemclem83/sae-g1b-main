package fr.univ_amu.iut.DAO.JPA;

import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOProfJPA implements DAOProf {
    private final EntityManager entityManager;
    public DAOProfJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Prof obj) {
        return false;
    }

    @Override
    public List<Prof> findAll() {
        return null;
    }

    @Override
    public Prof getById(Integer id) {
        return null;
    }

    @Override
    public Prof insert(Prof obj) {
        return null;
    }

    @Override
    public boolean update(Prof obj) {
        return false;
    }

    @Override
    public List<Prof> findByNom(String nom) {
        return null;
    }

    @Override
    public List<Prof> findMatSpec(Module matSpec) {
        return null;
    }

    @Override
    public int computeNbProf() {
        return 0;
    }
}

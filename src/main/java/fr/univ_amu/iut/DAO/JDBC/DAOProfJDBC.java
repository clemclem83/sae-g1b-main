package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOProf;
import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;

import java.util.List;

public class DAOProfJDBC implements DAOProf {
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

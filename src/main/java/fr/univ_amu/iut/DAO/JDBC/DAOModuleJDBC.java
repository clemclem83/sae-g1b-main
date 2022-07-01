package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.entity.Module;
import fr.univ_amu.iut.entity.Prof;

import java.util.List;

public class DAOModuleJDBC implements DAOModule {
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

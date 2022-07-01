package fr.univ_amu.iut.DAO.factory;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.DAO.JDBC.DAOModuleJDBC;
import fr.univ_amu.iut.DAO.JDBC.DAOProfJDBC;
import fr.univ_amu.iut.DAO.JDBC.Database;
import fr.univ_amu.iut.DAO.factory.DAOFactory;
import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;

public final class DAOFactoryJDBC implements DAOFactory {
    static {
        Database.connect();
    }
    @Override
    public DAOEtudiant createDAOEtudiant() {
        return new DAOEtudiantJDBC();
    }

    @Override
    public DAOProf createDAOProf() {
        return new DAOProfJDBC();
    }

    @Override
    public DAOModule createDAOModule() {
        return new DAOModuleJDBC();
    }
}

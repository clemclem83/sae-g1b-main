package fr.univ_amu.iut.DAO.factory;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.DAOModule;
import fr.univ_amu.iut.DAO.DAOProf;

public interface DAOFactory {
    DAOEtudiant createDAOEtudiant();

    DAOProf createDAOProf();

    DAOModule createDAOModule();
}

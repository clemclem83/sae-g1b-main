package fr.univ_amu.iut;


import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.factory.DAOFactoryProducer;
import fr.univ_amu.iut.DAO.factory.DAOType;

public class ListeEntiteAvecDAOJDBC {

    public static void main(String[] args) {
        DAOEtudiant dao = DAOFactoryProducer.getFactory(DAOType.JDBC).createDAOEtudiant();
        System.out.println(dao.findAll());
        System.out.println("\nOk.\n");
    }
}

open module tp.persistence {
    requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;

    requires jakarta.persistence;

    exports fr.univ_amu.iut;
    exports fr.univ_amu.iut.DAO;
    exports fr.univ_amu.iut.entity;
    exports fr.univ_amu.iut.connexion;
    exports fr.univ_amu.iut.DAO.factory;
    exports fr.univ_amu.iut.DAO.JDBC;
}
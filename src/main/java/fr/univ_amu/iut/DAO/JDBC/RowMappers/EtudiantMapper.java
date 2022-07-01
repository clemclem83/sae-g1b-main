package fr.univ_amu.iut.DAO.JDBC.RowMappers;

import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.entity.Etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantMapper implements RowMapper<Etudiant> {
    @Override
    public Etudiant mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return DAOEtudiantJDBC.extractEtudiant(resultSet);
    }
}

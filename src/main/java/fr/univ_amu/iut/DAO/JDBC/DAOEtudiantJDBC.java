package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.entity.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DAOEtudiantJDBC implements DAOEtudiant {
    private final PreparedStatement createStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement deleteStatement;
    private final PreparedStatement getById;
    private final PreparedStatement findByAnnee;
    private final PreparedStatement findByGroupe;
    private final PreparedStatement findByNom;
    private final PreparedStatement findAll;
    private final PreparedStatement computeNbEtudiant;
    public DAOEtudiantJDBC() {
        getById = Database.prepare("SELECT * FROM ETUDIANT WHERE NUM_ET = ?" );
        deleteStatement = Database.prepare("DELETE FROM ETUDIANT WHERE NUM_ET = ?");
        updateStatement = Database.prepare("UPDATE ETUDIANT SET NOM_ET = ?,PRENOM_ET = ?,CP_ET = ?,VILLE_ET = ?,ANNEE = ?,GROUPE = ? WHERE NUM_ET = ?");
        createStatement = Database.prepareInsert("INSERT INTO ETUDIANT (NUM_ET,NOM_ET,PRENOM_ET,CP_ET,VILLE_ET,ANNEE,GROUPE) VALUES (?,?,?,?,?,?,?)");
        findByAnnee = Database.prepare("SELECT * FROM ETUDIANT WHERE ANNEE = ?");
        findByGroupe = Database.prepare("SELECT * FROM ETUDIANT WHERE GROUPE = ?");
        findByNom = Database.prepare("SELECT * FROM ETUDIANT WHERE NOM_ET = ?");
        findAll = Database.prepare("SELECT * FROM ETUDIANT");
        computeNbEtudiant = Database.prepare("SELECT COUNT(*) FROM ETUDIANT");
    }

    @Override
    public int computeNbEtudiant() {
        int nbEtudiants = 0;
        try {
            ResultSet resultSet = Objects.requireNonNull(computeNbEtudiant).executeQuery();
            if (resultSet.first()) {
                nbEtudiants = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbEtudiants;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        return null;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        return null;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            Objects.requireNonNull(findByNom).setString(1,nomEt);
            ResultSet resultSet = findByNom.executeQuery();
            extractEtudiants(resultSet, etudiants);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            ResultSet resultSet = Objects.requireNonNull(findAll).executeQuery();
            extractEtudiants(resultSet, etudiants);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    public static Etudiant extractEtudiant(ResultSet result) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setNumEt(result.getInt("NUM_ET"));
        etudiant.setNomEt(result.getString("NOM_ET"));
        etudiant.setPrenomEt(result.getString("PRENOM_ET"));
        etudiant.setCpEt(result.getString("CP_ET"));
        etudiant.setVilleEt(result.getString("VILLE_ET"));
        etudiant.setAnnee(result.getInt("ANNEE"));
        etudiant.setGroupe(result.getInt("GROUPE"));
        return etudiant;
    }

    private void extractEtudiants(ResultSet result, List<Etudiant> etudiants) throws SQLException {
        while (result.next()) {
            Etudiant etudiant = extractEtudiant(result);
            etudiants.add(etudiant);
        }
    }

    @Override
    public Etudiant getById(Integer id) {
        Etudiant etudiant = new Etudiant();
        try {
            Objects.requireNonNull(getById).setInt(1, id);
            ResultSet result = getById.executeQuery();
            if (result.first()) {
                etudiant = extractEtudiant(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    @Override
    public boolean delete(Etudiant p) {
        try{
            synchronized (Objects.requireNonNull(deleteStatement)){
                deleteStatement.setInt(1,p.getNumEt());
                int id = deleteStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Etudiant insert(Etudiant p) {
        try {
            synchronized (Objects.requireNonNull(createStatement)) {
                createStatement.setInt(1, p.getNumEt());
                createStatement.setString(2, p.getNomEt());
                createStatement.setString(3, p.getPrenomEt());
                createStatement.setString(4, p.getCpEt());
                createStatement.setString(5, p.getVilleEt());
                createStatement.setInt(6, p.getAnnee());
                createStatement.setInt(7, p.getGroupe());
                int id = createStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            return null;
        }

        return p;
    }

    @Override
    public boolean update(Etudiant p) {
        try {
            synchronized (Objects.requireNonNull(updateStatement)) {
                updateStatement.setString(1, p.getNomEt());
                updateStatement.setString(2, p.getPrenomEt());
                updateStatement.setString(3, p.getCpEt());
                updateStatement.setString(4, p.getVilleEt());
                updateStatement.setInt(5, p.getAnnee());
                updateStatement.setInt(6, p.getGroupe());
                updateStatement.setInt(7, p.getNumEt());

                int id = Objects.requireNonNull(createStatement).executeUpdate();

                if(id== 0)
                    return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}

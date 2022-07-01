package fr.univ_amu.iut;

// Importer les classes jdbc
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.univ_amu.iut.connexion.ConnexionUnique;
import fr.univ_amu.iut.entity.Etudiant;

public class ListeEntite {
    // La requete de test
    private static final String reqEtudiantsAixois = "SELECT NUM_ET, NOM_ET, PRENOM_ET, CP_ET, VILLE_ET, ANNEE, GROUPE  "
            +
            "FROM ETUDIANT " +
            "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) {
        // Connexion a la base de données
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            System.out.println("Connecte\n");

            // Creation d'une instruction SQL
            Statement statement = conn.createStatement();

            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiantsAixois);
            ResultSet result = statement.executeQuery(reqEtudiantsAixois);

            List<Etudiant> etudiants = new ArrayList<>();
            // Affichage du resultat
            while (result.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(result.getInt("NUM_ET"));
                etudiant.setNomEt(result.getString("NOM_ET"));
                etudiant.setPrenomEt(result.getString("PRENOM_ET"));
                etudiant.setCpEt(result.getString("CP_ET"));
                etudiant.setVilleEt(result.getString("VILLE_ET"));
                etudiant.setAnnee(result.getInt("ANNEE"));
                etudiant.setGroupe(result.getInt("GROUPE"));
                etudiants.add(etudiant);
            }
            System.out.println(etudiants);

            // Fermeture de l'instruction (liberation des ressources)
            statement.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}

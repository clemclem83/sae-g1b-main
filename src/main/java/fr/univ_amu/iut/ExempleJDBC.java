package fr.univ_amu.iut;

// Importer les classes jdbc
import java.sql.*;


public class ExempleJDBC {
    // Chaine de connexion
    static final String CONNECT_URL = "jdbc:postgresql://tyke.db.elephantsql.com/plopplop";
    static final String LOGIN = "";
    static final String PASSWORD = "";
    // La requete de test
    private static final String reqEtudiantsAixois = "SELECT NUM_ET, NOM_ET, PRENOM_ET, VILLE_ET, ANNEE, GROUPE  "
            +
            "FROM ETUDIANT " +
            "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) {
        // Connexion a la base de données
        System.out.println("Connexion");
        try (Connection conn = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD)) {
            System.out.println("Connecte\n");

            // Creation d'une instruction SQL
            Statement statement = conn.createStatement();

            // Execution de la requete
            System.out.println("Execution de la requete : " + reqEtudiantsAixois);
            ResultSet resultSet = statement.executeQuery(reqEtudiantsAixois);

            // Affichage du resultat
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("NUM_ET") + " ");
                System.out.print(resultSet.getString("NOM_ET") + " ");
                System.out.print(resultSet.getString("PRENOM_ET") + " ");
                System.out.print(resultSet.getInt("ANNEE") + " ");
                System.out.println(resultSet.getInt("GROUPE"));
            }

            // Fermeture de l'instruction (liberation des ressources)
            statement.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}

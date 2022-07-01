package fr.univ_amu.iut;

import fr.univ_amu.iut.entity.Etudiant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.List;

public class AfficherLesEtudiants extends Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionPedaPU");
    private static final EntityManager em = emf.createEntityManager();
    private TableView<Etudiant> table;
    private TableColumn<Etudiant, String> nom;
    private TableColumn<Etudiant, Integer> numero;
    private TableColumn<Etudiant, String> prenom;
    private TableColumn<Etudiant, String> ville;
    private TableColumn<Etudiant, Integer> annee;
    private TableColumn<Etudiant, Integer> groupe;
    private ObservableList<Etudiant> data;
    private HBox boutons;
    private Button ajouter;
    private Button supprimer;
    private VBox racine;

    public static void main(String[] args) {
        launch(args);
    }

    private static TableColumn<Etudiant, Integer> initialiserColonneNumero() {
        return null;
    }

    private static TableColumn<Etudiant, String> initialiserColonneNom() {
        return null;
    }

    private static TableColumn<Etudiant, String> initialiserColonnePrenom() {
        return null;
    }

    private static TableColumn<Etudiant, String> initialiserColonneVille() {
        return null;
    }

    private static TableColumn<Etudiant, Integer> initialiserColonneAnnee() {
        return null;
    }

    private static TableColumn<Etudiant, Integer> initialiserColonneGroupe() {
        return null;
    }

    @Override
    public void start(Stage stage) {
        initialiserTable();
        initialiserBoutons();
        initialiserRacine();

        Scene scene = new Scene(racine, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Liste d'étudiants");
        stage.sizeToScene();
        stage.show();
    }

    private void initialiserRacine() {

    }

    private void initialiserBoutons() {

    }

    private void initialiserBoutonSupprimer() {

    }

    private void initialiserBoutonAjouter() {

    }

    private void initialiserTable() {
        table = new TableView<>();
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().select(0);

        initialiserColonnes();
        insererColonnes();
        remplirDonnees();

        VBox.setVgrow(table, Priority.ALWAYS);
    }

    private void initialiserColonnes() {
        numero = initialiserColonneNumero();
        nom = initialiserColonneNom();
        prenom = initialiserColonnePrenom();
        ville = initialiserColonneVille();
        groupe = initialiserColonneGroupe();
        annee = initialiserColonneAnnee();
    }

    private void insererColonnes() {
        table.getColumns().addAll(List.of(numero, nom, prenom, ville, annee, groupe));
    }

    private void remplirDonnees() {
        data = listerEtudiants();
        table.setItems(data);
    }

    private ObservableList<Etudiant> listerEtudiants() {
        return null;
    }

    private void ajouterEtudiant(ActionEvent event) {

    }

    private void supprimerEtudiant(ActionEvent event) {

    }
}

package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.Thematique;
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

import java.util.List;

public class MenuMain extends Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU");
    private static final EntityManager em = emf.createEntityManager();
    private TableView<Usage> U;
    private TableColumn<Usage,Integer>id;
    private TableColumn<Usage,String>nom;
    private TableColumn<Usage,String>description;
    private ObservableList<Usage> data;
    private HBox boutons;
    private Button usage;
    private VBox racine;
    @Override
    public void start(Stage stage) {
        initialiserTable();
        initialiserBoutons();
        initialiserRacine();

        Scene scene = new Scene(racine, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Académies de France");
        stage.sizeToScene();
        stage.show();
    }

    private void initialiserRacine() {
        racine = new VBox();
        racine.setPadding(new Insets(10));
        racine.getChildren().addAll(U,boutons);
    }

    private void initialiserBoutons() {
        boutons = new HBox(10);
        boutons.setPadding(new Insets(10));
        boutons.setAlignment(Pos.CENTER);
        initialiserBoutonUsage();
        boutons.getChildren().addAll(usage);
    }

    private void initialiserBoutonUsage() {
        usage = new Button("Usage");
        usage.setOnAction(this::supprimerActeur);
    }

    private void initialiserTable() {
        U = new TableView<>();
        U.setEditable(true);
        U.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        U.getSelectionModel().select(0);

        initialiserColonnes();
        insererColonnes();
        remplirDonnees();

        VBox.setVgrow(U, Priority.ALWAYS);
    }

    private static TableColumn<Usage, Integer> initialiserColonneId() {
        TableColumn<Usage, Integer> code = new TableColumn<>("Identiifiant");
        code.setCellValueFactory(new PropertyValueFactory<>("id"));
        return code;
    }
    private static TableColumn<Usage, String> initialiserColonneNom() {
        TableColumn<Usage, String> nom = new TableColumn<>("Nom");
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        nom.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage theme = event.getTableView().getItems().get(index);
            em.getTransaction().begin();
            theme.setNom(event.getNewValue());
            em.getTransaction().commit();
        });
        return nom;
    }
    private static TableColumn<Usage, String> initialiserColonneDescription() {
        TableColumn<Usage, String> description = new TableColumn<>("Description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage theme = event.getTableView().getItems().get(index);
            em.getTransaction().begin();
            theme.setNom(event.getNewValue());
            em.getTransaction().commit();
        });
        return description;
    }
    private void initialiserColonnes() {
        id = initialiserColonneId();
        nom = initialiserColonneNom();
        description = initialiserColonneDescription();
    }

    private void insererColonnes() {
        U.getColumns().addAll(List.of(id, nom,description));
    }

    private void remplirDonnees() {
        data = listerUsage();
        U.setItems(data);
    }

    private ObservableList<Usage> listerUsage() {
        TypedQuery<Usage> query = em.createNamedQuery("Usage.findAll", Usage.class);
        return FXCollections.observableList(query.getResultList());
    }

    private void supprimerActeur(ActionEvent event) {
        if (U.getItems().size() == 0) return;

        em.getTransaction().begin();
        em.remove(U.getSelectionModel().getSelectedItem());
        em.getTransaction().commit();

        int selectedRowIndex = U.getSelectionModel().getSelectedIndex();

        data.remove(selectedRowIndex);

        if (selectedRowIndex != 0) {
            selectedRowIndex = selectedRowIndex - 1;
        }

        U.requestFocus();
        U.scrollTo(selectedRowIndex);
        U.getSelectionModel().select(selectedRowIndex);
        U.getFocusModel().focus(selectedRowIndex);
    }

    public static void main(String[] args){launch(args);
    }

}



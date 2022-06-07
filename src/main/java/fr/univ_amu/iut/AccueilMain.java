package fr.univ_amu.iut;

import fr.univ_amu.iut.dao.*;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;


public class AccueilMain extends Application {
    private HBox boutons;
    private VBox racine;
    private Button entree;
    France france;
    @Override
    public void start(Stage stage) {

        TabPane onglets = new TabPane();

        //Tab accueil = new Tab("Accueil", new Label("Show all planes available"));
        initialiserBoutons();
        initialiserRacine();
        Scene scene = new Scene(racine, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Page d'accueil");
        stage.sizeToScene();
        stage.show();
    }

    private void initialiserRacine() {


        racine = new VBox();
        racine.setPadding(new Insets(10));
        racine.getChildren().addAll(boutons);
    }

    private void initialiserBoutons() {
        boutons = new HBox(10);
        boutons.setPadding(new Insets(10));
        boutons.setAlignment(Pos.CENTER);
        initialiserBoutonEntree();
        boutons.getChildren().addAll(entree);
    }

    private void initialiserBoutonEntree() {
        entree = new Button("Accéder à l'application");
        DAOFactory JPAfactory = DAOFactoryProducer.getFactory(DAOType.JPA);
        DAOUsage daoUsage = JPAfactory.createDAOUsage();

        EventHandler<ActionEvent> changer;

        changer = evt ->{
            france = FranceBuilder.create()
                    .mousePressHandler(event ->{
                        AcademiePath academiePath = (AcademiePath) event.getSource();

                        List<Usage> usages = daoUsage.findByAcademie(academiePath.getAcademie());

                        VBox resultats = new VBox();
                        for( Usage usage : usages){
                            resultats.getChildren().add(new Label(usage.getCommentaire()));
                        }

                        Stage stageResultats = new Stage();
                        Scene sceneResultats = new Scene(resultats);
                        stageResultats.setScene(sceneResultats);
                        stageResultats.show();
                    })
                    .selectionEnabled(true)
                    .build();

            Stage stageFrance = new Stage();
            Scene sceneFrance = new Scene(france);
            stageFrance.setScene(sceneFrance);
            stageFrance.show();
        };
        entree.setOnAction(changer);//changer pour basculer sur une page si appuyer
    }


    public static void main(String[] args){launch(args);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccueilMain that = (AccueilMain) o;
        return Objects.equals(boutons, that.boutons) && Objects.equals(racine, that.racine) && Objects.equals(entree, that.entree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boutons, racine, entree);
    }
}


/*
public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Planes", new Label("Show all planes available"));
        Tab tab2 = new Tab("Cars"  , new Label("Show all cars available"));
        Tab tab3 = new Tab("Boats" , new Label("Show all boats available"));

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
    }
}
*/

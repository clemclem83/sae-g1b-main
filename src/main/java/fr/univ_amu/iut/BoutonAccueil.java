package fr.univ_amu.iut;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;



public class BoutonAccueil extends GridPane{

    public  BoutonAccueil() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fr/univ_amu/iut/META-INF/AccueilView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

    }

}


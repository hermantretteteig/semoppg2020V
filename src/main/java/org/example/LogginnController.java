package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class LogginnController  {


    private static Scene scene;


    @FXML
    private void nyBruker() throws IOException {
        //App.setRoot("nybruker");
        App.nykunde();

        //App.scene.set
        /*Pane pane = new Pane();
        Scene scene = new Scene(scene, 300, 200);

        scene = new Scene(loadFXML("logginn"));
        stage.setScene(scene);
        stage.show();

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.*/
    }

    @FXML
    private void logginn() throws IOException {
        App.setRoot("secondary");
    }
}

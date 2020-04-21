package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogginnController  {


    private static Scene scene;


    @FXML
    private void nyBruker() throws IOException {
        //App.setRoot("nybruker");
        App.nybruker();

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

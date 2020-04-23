package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

//Halla, funker fett
// Ny test - Salem Hamidi sdfhdah test2

public class App extends Application {
    static AnchorPane root;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("logginn"));
        stage.setScene(scene);
        stage.setTitle("Datamaskinkonfiguering");
        stage.setResizable(false);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void nykunde() throws IOException {
        Stage stage = new Stage();
        scene = new Scene(loadFXML("nykunde"), 344, 374);

        stage.setTitle("Ny kunde");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
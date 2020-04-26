package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

    private static Scene hovedscene;
    private static Scene registrerScene;

    @Override
    public void start(Stage stage) throws IOException {
        hovedscene = new Scene(loadFXML("logginn"));
        stage.setScene(hovedscene);
        stage.setTitle("Datamaskinkonfiguering");
        stage.setResizable(false);
        stage.show();
        Image ikoner = new Image("ikoner/Gnome-computer.png");
        stage.getIcons().add(ikoner);


    }

    public static void setRoot(String fxml) throws IOException {
        hovedscene.setRoot(loadFXML(fxml));

    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        System.out.println("Filbane: "+App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void nyttLiteVindu(String fxml, String tittel, int hoyde, int lengde) throws IOException {
        Stage stage = new Stage();
        registrerScene = new Scene(loadFXML(fxml), hoyde, lengde);
        stage.setTitle(tittel);
        stage.setScene(registrerScene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
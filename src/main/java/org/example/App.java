package org.example;

import eksempeldata.Eksempeldata;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    static AnchorPane root;

    private static Scene hovedscene;
    private static Scene registrerScene;

    @Override
    public void start(Stage stage) throws IOException, CloneNotSupportedException {
        //Legger in eksepeldata
        Eksempeldata.GenererEksempeldata();

        //Oppretteter en ny scene med FXML-filen "logginn"
        //Legger inn diverse konfigurasjoner til scenen/staget
        hovedscene = new Scene(loadFXML("logginn"));
        stage.setScene(hovedscene);
        stage.setTitle("Datamaskinkonfiguering");
        stage.setResizable(false);
        hovedscene.getStylesheets().add("/style/logginn.css");
        stage.show();
        Image ikoner = new Image("ikoner/Gnome-computer.png");
        stage.getIcons().add(ikoner);

    }

    //Metode som brukes for å navigere til forskjellige FXML-filer i programet
    public static void setRoot(String fxml) throws IOException {
        hovedscene.setRoot(loadFXML(fxml));
    }

    //Laster inn bestemt FXML-fil
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //Brukes til mindre vinduer, som registrering av kunde/admin
    public static void nyttLiteVindu(String fxml, String tittel, int lengde, int hoyde) throws IOException {
        Stage stage = new Stage();
        registrerScene = new Scene(loadFXML(fxml), lengde, hoyde);
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
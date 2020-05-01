package org.example.adminController;

import data.KomponentData;
import filbehandling.LagreJOBJ;
import filbehandling.LesJOBJ;
import filbehandling.Traad;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.komponent.Komponent;
import org.example.App;

import java.io.File;

import static data.KomponentData.getAlleKomponenter;

public class DashboardAdminController {

    @FXML
    private AnchorPane adminPanel;
    @FXML
    public GridPane gridpane;

    private Traad traad;


    /*
        1. Legg til skjermkort/ komponent
        2. Trykk lagre
        3. Filen befinner seg i mappen C:\Users\brukernavn\Datamaskinkonfigurering\komponenter
    */

    @FXML
    public void hentFilAction() {
        //Filbane.
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/komponenter");
        //Lager filbanen om den ikke allerede eksisterer.
        //TODO kan vel fjerne denne.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }
        //Oppretter FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        //TODO try catch?
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj")
        );

        //Åpner filechooser og henter data hvis fil er valgt
        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        /*if(file != null){
            LesJOBJ lesJOBJ = new LesJOBJ();
            lesJOBJ.lesKomponent(file.getAbsolutePath());
        }*/
        if(file != null){
            traad = new Traad(file.getAbsolutePath());
            Thread thread = new Thread(traad);
            traad.setOnSucceeded(this::threadDone);
            traad.setOnFailed(this::threadFailed);
            //btnNyttKomponent.setDisable(true);
            gridpane.setDisable(true);
            //btnHentFil.setDisable(true);
            thread.start();
        }
        ObservableList<Komponent> komponenter = KomponentData.getAlleKomponenter();
        for(Komponent komponent : komponenter){
            System.out.println("---------------------------");
            System.out.println(komponent);
        }

    }


    @FXML
    public void eksportFilAction() {
        //Filbane.
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/komponenter");
        //Lager filbanen om den ikke allerede eksisterer.
        //TODO putte denne i en try catch, og lage en alternativ løsning.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }
        //Oppretter filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg filplassering");
        //TODO try catch?
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj"));

        //Åpner filechooser og eksporterer data
        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if(file != null){
            LagreJOBJ lagre = new LagreJOBJ();
            lagre.lagreKomponent(getAlleKomponenter(), file.getAbsolutePath());
        }

    }

    public void nyKomponentAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void nyAdminAction() throws Exception{
        App.nyttLiteVindu("adminView/nyAdmin", "Legg til ny administrator", 344, 374);
    }

    @FXML
    public void endreKomponentAction() throws Exception{
        App.setRoot("adminView/endreKomponent/endreKomponent");
    }

    @FXML
    public void loggUtAction() throws Exception{
        //kode som avslutter session

        App.setRoot("loggInn");

    }

    private void threadDone(WorkerStateEvent e) {
        System.out.println("Fil hentet");
        gridpane.setDisable(false);
    }

    private void threadFailed(WorkerStateEvent event) {
        System.out.println("Henting av fil feilet");
        gridpane.setDisable(false);
    }
}

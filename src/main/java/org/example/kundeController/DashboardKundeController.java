package org.example.kundeController;

import data.Eksempeldata;
import filbehandling.LagreCSV;
import filbehandling.LagreJOBJ;
import filbehandling.LesCSV;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.App;

import java.io.File;
import java.io.IOException;

import static data.KomponentData.getAlleKomponenter;

public class DashboardKundeController {

@FXML
public AnchorPane kundePanel;

    public void lagreAction() throws IOException {
        //TODO lage DatamaskinData for å hente kunde kjøp for lagring.
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/komponenter");
        //Lager filbanen om den ikke allerede eksisterer.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }

        //Oppretter filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg filplassering");
        //TODO try catch?
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Filer", "*.csv"));

        //Åpner filechooser og eksporterer data
        Stage stage = (Stage) kundePanel.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if(file != null) {
            LagreCSV lagre = new LagreCSV();
            lagre.lagreDatamaskin(Eksempeldata.GenererEksempeldata(), file.getAbsolutePath());
        }
    }

    public void nyttKjopAction() throws IOException {
        App.setRoot("kundeView/nyttKjop");
    }

    public void tidligereKjopAction(){

    }

    @FXML
    public void loggUtAction() throws Exception{
        //kode som avslutter session
        App.setRoot("loggInn");

    }

}

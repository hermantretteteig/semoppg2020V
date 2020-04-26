package org.example.adminController;
import data.KomponentData;
import filbehandling.LesJOBJ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.App;
import org.example.adminController.nyKomponent.nySkjermkortController;
import filbehandling.LagreJOBJ;

import java.io.File;

import static data.KomponentData.getAlleKomponenter;

public class DashboardAdminController {

    @FXML
    private Button lagreFil;

    @FXML
    private AnchorPane adminPanel;


    /*
        1. Legg til skjermkort/ komponent
        2. Trykk lagre
        3. Filen befinner seg i mappen C:\Users\brukernavn\Datamaskinkonfigurering\komponenter
    */
    @FXML
    public void lagreAction(ActionEvent actionEvent) throws Exception{
        //Filbane.
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/komponenter");
        //Lager filbanen om den ikke allerede eksisterer.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }
        //FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj")
        );

        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if(file != null){
            LagreJOBJ lagreJOBJ = new LagreJOBJ();
            lagreJOBJ.lagreKomponent(getAlleKomponenter(), file.getAbsolutePath());
        }

        //TODO Kode for å hente fil
        /*//FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj")
        );

        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
            LesJOBJ lesJOBJ = new LesJOBJ();
            lesJOBJ.lesKomponent(file.getAbsolutePath());
        }*/

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
}

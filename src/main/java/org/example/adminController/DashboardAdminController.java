package org.example.adminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.komponent.Skjermkort;
import org.example.App;
import org.example.adminController.nyKomponent.nySkjermkortController;
import org.example.filbehandling.LagreJOBJ;

import java.io.File;
import java.nio.file.Paths;

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
            nySkjermkortController controller = new nySkjermkortController();
            LagreJOBJ lagreJOBJ = new LagreJOBJ();
            lagreJOBJ.lagreKomponent( controller.skjermkort, file.getAbsolutePath());
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
}

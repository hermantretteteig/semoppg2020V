package org.example.kundeController;

import data.InnloggetBrukerData;
import data.OrdreData;
import exceptions.InvalidBooleanFormatException;
import exceptions.InvalidNumberFormatException;
import exceptions.InvalidOrdreFormatException;
import filbehandling.Varsler.VarslerFilbehandling;
import filbehandling.LagreCSV;
import filbehandling.LesCSV;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.App;

import java.io.File;
import java.io.IOException;

public class DashboardKundeController {

@FXML
public AnchorPane kundePanel;

    public void eksporterFilAction() {
        //Åpner filechooser og eksporterer data
        Stage stage = (Stage) kundePanel.getScene().getWindow();
        File file = opprettFilechooser("Velg filbane").showSaveDialog(stage);
        try {
            if(file != null) {
                LagreCSV.lagreOrdre(OrdreData.getOrdreArray(), file.getAbsolutePath());
                VarslerFilbehandling.suksessLagreFil();
            }
        } catch (Exception e) {
            VarslerFilbehandling.feiletLagreFil();
            e.printStackTrace();
        }

    }

    public void hentFilAction() throws IOException{
        Alert alert = VarslerFilbehandling.bekreftHentFil();
        if(alert.getResult().getButtonData().isDefaultButton()) {
            //Åpner filechooser og henter data
            Stage stage = (Stage) kundePanel.getScene().getWindow();
            File file = opprettFilechooser("Velg fil").showOpenDialog(stage);
            if (file != null) {
                try {
                    OrdreData.setAlleOrdre(LesCSV.lesOrdre(file.getAbsolutePath()));
                    VarslerFilbehandling.suksessHentFil();
                } catch (InvalidNumberFormatException f) {
                    VarslerFilbehandling.feiletHentFilNumber();
                    f.printStackTrace();
                } catch (InvalidBooleanFormatException g) {
                    VarslerFilbehandling.feiletHentFilBoolean();
                    g.printStackTrace();
                } catch (InvalidOrdreFormatException e) {
                    VarslerFilbehandling.feiletHentFilOrdre();
                    e.printStackTrace();
                }

            }
        }
    }

    public void nyttKjopAction() throws IOException {
        App.setRoot("kundeView/nyttKjop");
    }

    public void tidligereKjopAction() throws IOException{
        App.setRoot("kundeView/tidligereKjop");
    }

    public void endreKundeinformasjonAction() throws IOException{
        App.setRoot("kundeView/endreKundeinfoKunde");
    }

    @FXML
    public void loggUtAction() throws Exception{
        InnloggetBrukerData.loggUtKunde();
        App.setRoot("loggInn");

    }

    private FileChooser opprettFilechooser(String string){
        //Forhåndsvalgt ilbane: C:\Users\brukernavn\Datamaskinkonfigurering\komponenter
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/Ordre");
        //Oppretter filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(string);

        //Lager filbanen om den ikke allerede eksisterer, og setter filechooser sin filbane til denne.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }else{
            fileChooser.setInitialDirectory(filBane);
            fileChooser.setInitialDirectory(filBane);
        }
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Filer", "*.csv"));
        return fileChooser;
    }



}

package org.example.adminController;

import data.InnloggetBrukerData;
import data.KomponentData;
import filbehandling.LagreJOBJ;
import filbehandling.Traad;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.komponent.Komponent;
import org.example.App;

import java.io.File;
import java.util.Optional;

import static data.KomponentData.getAlleKomponenter;

public class DashboardAdminController {

    @FXML
    private AnchorPane adminPanel;
    @FXML
    public Button btnNyttKomponent, btnEndreKomponent, btnLagreFil, btnHentFil,
                  btnEndreKunde, btnTidligereKjop ,btnNyAdmin, btnLoggUt;

    private Traad traad;

    @FXML
    public void hentFilAction() {
        hentFil();
    }


    @FXML
    public void eksportFilAction() {
        lagreFil();
    }

    public void nyKomponentAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    public void tidligerKjopAction() throws Exception{
        App.setRoot("adminView/tidligereKjop");
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
    public void endreKundeAction() throws Exception{
        App.setRoot("adminView/endreKunde");
    }

    @FXML
    public void loggUtAction() throws Exception{
        InnloggetBrukerData.loggUtAdmin();

        App.setRoot("loggInn");

    }

    private FileChooser opprettFilechooser(String string){
        //Forhåndsvalgt ilbane: C:\Users\brukernavn\Datamaskinkonfigurering\komponenter
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering/komponenter");
        //Lager filbanen om den ikke allerede eksisterer.
        //TODO putte denne i en try catch, og lage en alternativ løsning.
        if (!filBane.exists()) {
            filBane.mkdirs();
        }
        //Oppretter filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(string);
        //TODO try catch?
        fileChooser.setInitialDirectory(filBane);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj"));
        return fileChooser;
    }

    private void lagreFil(){
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.OK_DONE);
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING, "", fortsett, avbryt);
        alert.setTitle("Hent fil");
        alert.setHeaderText("Alle endringer som ikke er lagret vil bli slettet.");
        alert.setContentText("Er du sikker på at du vil fortsette?");

        alert.showAndWait();

        if(alert.getResult().getButtonData().isDefaultButton()) {
            //Åpner filechooser og eksporterer data
            Stage stage = (Stage) adminPanel.getScene().getWindow();
            File file = opprettFilechooser("Velg filbane").showSaveDialog(stage);

            if (file != null) {
                LagreJOBJ.lagreListe(getAlleKomponenter(), file.getAbsolutePath());
            }
        }
    }

    private void hentFil(){
        //Åpner filechooser
        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = opprettFilechooser("Velg fil").showSaveDialog(stage);

        if (file != null) {
            traad = new Traad(file.getAbsolutePath());
            Thread thread = new Thread(traad);
            traad.setOnSucceeded(this::traadFerdig);
            traad.setOnFailed(this::traadFeilet);
            setDisable(true);
            thread.start();
        }
    }

    //Metode for å deaktivere alle knapper under innlasting av lister
    private void setDisable(Boolean bool){
        btnNyttKomponent.setDisable(bool);
        btnEndreKomponent.setDisable(bool);
        btnLagreFil.setDisable(bool);
        btnHentFil.setDisable(bool);
        btnEndreKunde.setDisable(bool);
        btnTidligereKjop.setDisable(bool);
        btnNyAdmin.setDisable(bool);
        btnLoggUt.setDisable(bool);
    }

    private void traadFerdig(WorkerStateEvent event) {
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Henting av fil");
        alert.setHeaderText("Filen ble hentet.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();

        setDisable(false);
    }

    private void traadFeilet(WorkerStateEvent event) {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Trykk på knappen for å avbryte.");
        alert.showAndWait();

        setDisable(false);
    }
}

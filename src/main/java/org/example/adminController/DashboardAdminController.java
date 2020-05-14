package org.example.adminController;

import data.InnloggetBrukerData;
import filbehandling.Alerts.JobjAlerts;
import filbehandling.Traader.TraadHentingAvFil;
import filbehandling.Traader.TraadLagringAvFil;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.App;

import java.io.File;

public class DashboardAdminController {

    @FXML
    private AnchorPane adminPanel;
    @FXML
    private Button btnNyttKomponent, btnEndreKomponent, btnLagreFil, btnHentFil,
                  btnEndreKunde, btnTidligereKjop ,btnNyAdmin, btnLoggUt;

    //TODO brukes denne Tore?
    @FXML
    private TraadLagringAvFil traadLagringAvFil;

    //Knapp for henting av fil
    @FXML
    public void hentFilAction(ActionEvent event) {
        hentFil();
    }

    //Knapp for eksportering av fil
    @FXML
    public void eksportFilAction(ActionEvent event) {
        lagreFil();
    }

    //Knapp som sender brukeren til ny komponent-viewet
    public void nyKomponentAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    //Knapp som sender brukeren til ny komponent-viewet
    public void tidligerKjopAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/tidligereKjop");
    }




    @FXML
    public void nyAdminAction(ActionEvent event) throws Exception{
        App.nyttLiteVindu("adminView/nyAdmin", "Legg til ny administrator", 344, 374);
    }

    @FXML
    public void endreKomponentAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/endreKomponent");
    }

    @FXML
    public void endreKundeAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/endreKunde");
    }

    @FXML
    public void loggUtAction(ActionEvent event) throws Exception{
        InnloggetBrukerData.loggUtAdmin();
        App.setRoot("loggInn");

    }
//TODO bør kanskje alle disse metodene under flyttes til en egen fil Tore?

    private FileChooser opprettFilechooser(String string){
        //Forhåndsvalgt ilbane: C:\Users\brukernavn\Datamaskinkonfigurering\komponenter
        File filBane = new File(System.getProperty("user.home"), "Datamaskinkonfigurering");
        //Oppretter filechooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(string);

        //Lager filbanen om den ikke allerede eksisterer, og setter filechooser sin filbane til denne.
        if (!filBane.exists()) {
            filBane.mkdirs();
            fileChooser.setInitialDirectory(filBane);
        }else{
            fileChooser.setInitialDirectory(filBane);
        }
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ Filer", "*.jobj"));
        return fileChooser;
    }

    private void lagreFil(){
        //Åpner filechooser og eksporterer data
        Stage stage = (Stage) adminPanel.getScene().getWindow();
        File file = opprettFilechooser("Velg filbane").showSaveDialog(stage);

        TraadLagringAvFil traad;

        //Sjekker at filobjektet ikke er tomt.
        if (file != null) {
            traad = new TraadLagringAvFil(file.getAbsolutePath());
            Thread thread = new Thread(traad);
            traad.setOnSucceeded(this::traadFerdigLagreFil);
            traad.setOnFailed(this::traadFeiletLagreFil);
            setDisable(true);
            thread.start();
        }
    }

    private void hentFil(){
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.OK_DONE);
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING, "", fortsett, avbryt);
        alert.setTitle("Hent fil");
        alert.setHeaderText("Alle endringer som ikke er lagret vil bli slettet.");
        alert.setContentText("Er du sikker på at du vil fortsette?");

        alert.showAndWait();

        if(alert.getResult().getButtonData().isDefaultButton()) {
            //Åpner filechooser
            Stage stage = (Stage) adminPanel.getScene().getWindow();
            File file = opprettFilechooser("Velg fil").showOpenDialog(stage);
            TraadHentingAvFil traad;

            //Sjekker at filobjektet ikke er tomt.
            if (file != null) {
                traad = new TraadHentingAvFil(file.getAbsolutePath());
                Thread thread = new Thread(traad);
                traad.setOnSucceeded(this::traadFerdigHentFil);
                traad.setOnFailed(this::traadFeiletHentFil);
                setDisable(true);
                thread.start();
            }
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

    //Metode som kjøres når tråden som kjøres ved henting av fil utføres riktig.
    private void traadFerdigHentFil(WorkerStateEvent event) {
        JobjAlerts.suksessLagreFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved henting av fil feiler
    private void traadFeiletHentFil(WorkerStateEvent event) {
        JobjAlerts.feiletHentFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil utføres riktig.
    private void traadFerdigLagreFil(WorkerStateEvent event) {
        JobjAlerts.suksessLagreFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil feiler
    private void traadFeiletLagreFil(WorkerStateEvent event) {
        JobjAlerts.feiletHentFil();
        setDisable(false);
    }


}

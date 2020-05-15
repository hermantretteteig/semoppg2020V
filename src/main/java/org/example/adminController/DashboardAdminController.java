package org.example.adminController;

import data.InnloggetBrukerData;
import filbehandling.Traader.TraadHentingAvFil;
import filbehandling.Traader.TraadLagringAvFil;
import filbehandling.Varsler.VarslerFilbehandling;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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


    private TraadLagringAvFil traadLagringAvFil;
    private TraadHentingAvFil traadHentingAvFil;

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
    @FXML
    public void nyKomponentAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    //Knapp som sender brukeren til ny tidligere kjøp / ordre
    @FXML
    public void tidligerKjopAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/tidligereKjop");
    }

    //Knapp som åpner viduet der det er mulig å legge til en ny administrator
    @FXML
    public void nyAdminAction(ActionEvent event) throws Exception{
        App.nyttLiteVindu("adminView/nyAdmin", "Legg til ny administrator", 344, 374);
    }

    //Knapp som sender brukeren til endre komponent-viewet
    @FXML
    public void endreKomponentAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/endreKomponent");
    }

    //Knapp som sender brukeren til endre kunde-viewet
    @FXML
    public void endreKundeAction(ActionEvent event) throws Exception{
        App.setRoot("adminView/endreKunde");
    }

    //Knapp som logger brukeren ut
    @FXML
    public void loggUtAction(ActionEvent event) throws Exception{
        InnloggetBrukerData.loggUtAdmin();
        App.setRoot("loggInn");

    }


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

        //Sjekker at filobjektet ikke er tomt.
        if (file != null) {
            traadLagringAvFil = new TraadLagringAvFil(file.getAbsolutePath());
            Thread thread = new Thread(traadLagringAvFil);
            traadLagringAvFil.setOnSucceeded(this::traadFerdigLagreFil);
            traadLagringAvFil.setOnFailed(this::traadFeiletLagreFil);
            setDisable(true);
            thread.start();
        }
    }

    private void hentFil(){
        Alert alert = VarslerFilbehandling.bekreftHentFil();
        if(alert.getResult().getButtonData().isDefaultButton()) {
            //Åpner filechooser
            Stage stage = (Stage) adminPanel.getScene().getWindow();
            File file = opprettFilechooser("Velg fil").showOpenDialog(stage);

            //Sjekker at filobjektet ikke er tomt.
            if (file != null) {
                traadHentingAvFil = new TraadHentingAvFil(file.getAbsolutePath());
                Thread thread = new Thread(traadHentingAvFil);
                traadHentingAvFil.setOnSucceeded(this::traadFerdigHentFil);
                traadHentingAvFil.setOnFailed(this::traadFeiletHentFil);
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
        VarslerFilbehandling.suksessHentFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved henting av fil feiler
    private void traadFeiletHentFil(WorkerStateEvent event) {
        VarslerFilbehandling.feiletHentFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil utføres riktig.
    private void traadFerdigLagreFil(WorkerStateEvent event) {
        VarslerFilbehandling.suksessLagreFil();
        setDisable(false);
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil feiler
    private void traadFeiletLagreFil(WorkerStateEvent event) {
        VarslerFilbehandling.feiletLagreFil();
        setDisable(false);
    }


}

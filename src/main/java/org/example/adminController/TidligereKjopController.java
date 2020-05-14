package org.example.adminController;

import data.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

import data.OrdreData;
import data.NyttKjopKomponentinfoViewData;
import data.ValgtOrdreSinDatamaskinData;

public class TidligereKjopController {
    @FXML
    private TableView<Ordre> ordre;
    @FXML
    private TableView komponentinfo;
    @FXML
    private TableView<Komponent> valgtDatamaskin;

    @FXML
    private TableColumn coKunde;

    //Oppretter et nytt objekt av de ulike listene som skal implementeres i tabellviewene
    private NyttKjopKomponentinfoViewData detaljeinformasjon = new NyttKjopKomponentinfoViewData();
    private ValgtOrdreSinDatamaskinData valgtdatamaskin = new ValgtOrdreSinDatamaskinData();
    private OrdreData alleOrdre = new OrdreData();


    /*Når en ordre er valgt skal komponentene til ordren hentes frem. Listen over komponenter
    settes til de komponentene som er konfigurert i datamaskinen.*/
    @FXML
    public void valgtOrdre(){
            //Komponentlisten oppdateres med ordrekomponentene
            valgtdatamaskin.hentValgtDatamaskin(valgtDatamaskin, ordre.getSelectionModel().getSelectedItem());
            //Ordrelisten oppdateres
            ordre.refresh();
    }

    /*
    Når en komponent er valgt i listen over komponenter skal detaljene til komponenten hentes frem.
    metoden under genererer et listeview med to kollonner, den ene kollonnen er en detalj, mens den
    andre kollonnen er verdien til detaljen, f. eks. for en prosessor "Antall kjerner: 8"
    */
    @FXML
    public void valgtKomponent(){
        //Sjekker at det faktisk er valgt en rad for å forhindre NullPointerException
        if(valgtDatamaskin.getSelectionModel().getSelectedItem()!=null) {
            //Setter komponinfotabellen synlig
            komponentinfo.setVisible(true);
            //Oppdaterer viewt med de nye detaljene til den valgte komponenten
            NyttKjopKomponentinfoViewData.OppdaterView(valgtDatamaskin.getSelectionModel().getSelectedItem());
            komponentinfo.refresh();
        }
    }

    //Knapp tilbake til dashboard
    @FXML
    public void tilbakeAction() throws Exception {
        App.setRoot("adminView/dashboardAdmin");
    }

    public void initialize() {
        //Henter inn alle detaljene som skal være tilgjenelig
        detaljeinformasjon.hentKomponentinfo(komponentinfo);
        //Henter alle ordre
        alleOrdre.hentAlleOrdre(ordre);

    //Slår sammen fornavn og etternavn til en kollonne
    coKunde.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordre, String>,
            ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Ordre, String> data){
            Kunde valgtKunde = KundeData.getKunde(data.getValue().getKundenr());

            return new SimpleStringProperty(valgtKunde.getFornavn()+" "+valgtKunde.getEtternavn());
        }
    });
    }

}

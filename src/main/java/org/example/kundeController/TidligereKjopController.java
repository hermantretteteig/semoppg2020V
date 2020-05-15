package org.example.kundeController;

import data.OrdreData;
import data.NyttKjopKomponentinfoViewData;
import data.ValgtOrdreSinDatamaskinData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

public class TidligereKjopController {

    @FXML
    public TableView<Ordre> ordre;
    public TableView komponentinfo;
    public TableView<Komponent> valgtDatamaskin;

    private NyttKjopKomponentinfoViewData collection1 = new NyttKjopKomponentinfoViewData();
    private ValgtOrdreSinDatamaskinData collection2 = new ValgtOrdreSinDatamaskinData();
    private OrdreData collection3 = new OrdreData();


    @FXML
    private void valgtOrdre() {
            //Oppdaterer komponent-listen med komponenter som finnes i ordren som er "valgt"
            collection2.hentValgtDatamaskin(valgtDatamaskin, ordre.getSelectionModel().getSelectedItem());
            //Oppdaterer tabellen
            ordre.refresh();

    }

    /*Når en komponent er valgt i listen over komponenter skal detaljene til komponenten hentes frem.
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
    private void tilbakeAction(ActionEvent event) throws Exception {
        App.setRoot("kundeView/dashboardKunde");
    }

    @FXML
    private void initialize() {
        //Henter komponentinfo
        collection1.hentKomponentinfo(komponentinfo);
        //Henter kundens ordre
        collection3.hentKundensOrdre(ordre);

    }
}

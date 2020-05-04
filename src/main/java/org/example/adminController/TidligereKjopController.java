package org.example.adminController;

import data.NyttKjopKomponentinfoViewData;
import data.OrdreData;
import data.ValgtOrdreSinDatamaskinData;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
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
    private OrdreData alleOrdre = new OrdreData();


    @FXML
    public void valgtOrdre(){
        collection2.hentValgtDatamaskin(valgtDatamaskin, ordre.getSelectionModel().getSelectedItem());
        ordre.refresh();
    }



    @FXML
    public void valgtKomponent(){
        if(valgtDatamaskin.getSelectionModel().getSelectedItem()!=null) {
            komponentinfo.setVisible(true);
            NyttKjopKomponentinfoViewData.OppdaterView(valgtDatamaskin.getSelectionModel().getSelectedItem());
            komponentinfo.refresh();
        }
    }


    @FXML
    public void tilbakeAction() throws Exception {
        App.setRoot("kundeView/dashboardKunde");
    }


    public void initialize() {
        collection1.hentKomponentinfo(komponentinfo);
        alleOrdre.hentAlleOrdre(ordre);
    }

}

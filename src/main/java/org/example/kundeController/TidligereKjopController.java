package org.example.kundeController;

import data.OrdreData;
import data.KomponentData;
import data.NyttKjopKomponentinfoViewData;
import data.ValgtOrdreSinDatamaskinData;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import models.NyttKjopKomponentinfoView;
import models.kjop.Ordre;
import models.komponent.Datamaskin;
import models.komponent.Komponent;
import org.example.App;

public class TidligereKjopController {

    //public TreeTableColumn coPris;

    @FXML
    public TableView<Ordre> ordre;
    public TableView komponentinfo;
    public TableView<Komponent> valgtDatamaskin;

    private NyttKjopKomponentinfoViewData collection1 = new NyttKjopKomponentinfoViewData();
    private ValgtOrdreSinDatamaskinData collection2 = new ValgtOrdreSinDatamaskinData();
    private OrdreData collection3 = new OrdreData();


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
        collection3.hentKomponenttype(ordre);


        /*coVaremerke.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Komponent, String> param) {
                return param.getValue().getValue().getSSPVaremerke();
            }
        });



        coModell.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Komponent, String> param) {
                return param.getValue().getValue().getSSPModell();
            }
        });

        coPris.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Komponent, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TreeTableColumn.CellDataFeatures<Komponent, Double> param) {
                return param.getValue().getValue().getSSPPris();
            }
        });
        */

        //tabell.setShowRoot(false);
    }
}

package org.example.kundeController;

import data.KomponentData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import models.komponent.Komponent;
import models.komponent.Prosessor;
import models.komponent.Skjerm;

import java.util.Collection;

public class NyttKjopController {

    //public TreeTableColumn coPris;
    @FXML
    public TreeTableView<Komponent> tabell;

    @FXML
    public TreeTableColumn<Komponent, String> coVaremerke;
    public TreeTableColumn<Komponent, String> coModell;
    public TreeTableColumn<Komponent, Double> coPris;


    public static TreeItem<Komponent> getModel()
    {


        TreeItem<Komponent> prosssor = new TreeItem<>(new Komponent("", "Prosessorer", "", 0));

        TreeItem<Komponent> lagringsenhet = new TreeItem<>(new Komponent("", "Lagringsenheter", "", 0));



        //TreeItem<Komponent> skjerm = new TreeItem<>();
        for(Komponent enKompoent : KomponentData.getAlleKomponenter()){
            if(enKompoent.getClass().getSimpleName().equals("Prosessor")){
                prosssor.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Lagringsenhet")){
                lagringsenhet.getChildren().add(new TreeItem<>(enKompoent));
            }
        }

        TreeItem<Komponent> alleKomponener = new TreeItem<>(new Komponent("", "Komponenter", "", 0));


        alleKomponener.getChildren().setAll(prosssor, lagringsenhet);

        prosssor.setExpanded(true);
        lagringsenhet.setExpanded(true);
        alleKomponener.setExpanded(true);

        return alleKomponener;
    }



    private KomponentData nyttKjop = new KomponentData();


    public void initialize() {


        coVaremerke.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Komponent, String>, ObservableValue<String>>() {
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


        /*coPris.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue call(TreeTableColumn.CellDataFeatures<String, String> param) {
                return new SimpleStringProperty(param.getValue().getValue());
            }
        });*/
        tabell.setRoot(getModel());
        //tabell.setShowRoot(false);
    }
}

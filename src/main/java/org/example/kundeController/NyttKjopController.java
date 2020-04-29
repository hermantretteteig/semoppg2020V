package org.example.kundeController;

import data.HandlekurvData;
import data.KomponentData;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import models.HandlekurvVare;
import models.komponent.Komponent;

public class NyttKjopController {

    //public TreeTableColumn coPris;
    @FXML
    public TreeTableView<Komponent> tabell;

    @FXML
    public TableView tableHandekurv;

    @FXML
    public TreeTableColumn<Komponent, String> coVaremerke;
    public TreeTableColumn<Komponent, String> coModell;
    public TreeTableColumn<Komponent, Double> coPris;

    @FXML
    public TableColumn coHandlekurvNavn;
    public TableColumn coHandlekurvPris;


    private HandlekurvData collection = new HandlekurvData();


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

    @FXML
    public void leggTilIHandekurv(){
        Komponent valgtKomponent = tabell.getSelectionModel().getSelectedItem().getValue();
        System.out.println("Varenr: "+valgtKomponent.getVarenr());

        HandlekurvVare nyVare = new HandlekurvVare(valgtKomponent.getVarenr(), (valgtKomponent.getVaremerke()+" "+valgtKomponent.getModell()), valgtKomponent.getPris());
        HandlekurvData.nyVare(nyVare);
        tableHandekurv.refresh();


    }




    public void initialize() {
        coHandlekurvPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        collection.hentKomponenttype(tableHandekurv);
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

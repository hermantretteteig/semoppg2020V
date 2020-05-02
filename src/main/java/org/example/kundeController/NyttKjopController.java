package org.example.kundeController;

import data.HandlekurvData;
import data.KomponentData;
import data.NyttKjopKomponentinfoViewData;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

public class NyttKjopController {

    //public TreeTableColumn coPris;
    @FXML
    public TreeTableView<models.komponent.Komponent> tabell;

    @FXML
    public TableView tableHandekurv;
    public TableView komponentinfo;

    @FXML
    public TreeTableColumn<models.komponent.Komponent, String> coVaremerke;
    public TreeTableColumn<models.komponent.Komponent, String> coModell;
    public TreeTableColumn<models.komponent.Komponent, Double> coPris;

    @FXML
    public TableColumn coHandlekurvNavn;
    public TableColumn coHandlekurvPris;

    @FXML
    public Label lblTotalpris;

    private HandlekurvData collection = new HandlekurvData();
    private NyttKjopKomponentinfoViewData collection2 = new NyttKjopKomponentinfoViewData();

    public static TreeItem<models.komponent.Komponent> getModel()
    {

        TreeItem<models.komponent.Komponent> lagringsenheter = new TreeItem<>(new models.komponent.Komponent("", "Lagringsenheter", "", 0));
        TreeItem<models.komponent.Komponent> mus = new TreeItem<>(new models.komponent.Komponent("", "Mus", "", 0));
        TreeItem<models.komponent.Komponent> prosssor = new TreeItem<>(new models.komponent.Komponent("", "Prosessorer", "", 0));
        TreeItem<models.komponent.Komponent> skjermer = new TreeItem<>(new models.komponent.Komponent("", "Skjermer", "", 0));
        TreeItem<models.komponent.Komponent> skjermkort = new TreeItem<>(new models.komponent.Komponent("", "Skjermkort", "", 0));
        TreeItem<models.komponent.Komponent> tastaturer = new TreeItem<>(new models.komponent.Komponent("", "Tastaturer", "", 0));

        TreeItem<models.komponent.Komponent> alleKomponener = new TreeItem<>(new models.komponent.Komponent("", "Komponenter", "", 0));

        //TreeItem<Komponent> skjerm = new TreeItem<>();
        for(models.komponent.Komponent enKompoent : KomponentData.getAlleKomponenter()){

            if(enKompoent.getClass().getSimpleName().equals("Lagringsenhet")){
                lagringsenheter.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Mus")){
                mus.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Prosessor")){
                prosssor.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Skjerm")){
                skjermer.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Skjermkort")){
                skjermkort.getChildren().add(new TreeItem<>(enKompoent));
            }
            if(enKompoent.getClass().getSimpleName().equals("Tastatur")){
                tastaturer.getChildren().add(new TreeItem<>(enKompoent));
            }
        }


        alleKomponener.getChildren().setAll(lagringsenheter, mus, prosssor, skjermer, skjermkort, tastaturer);

        alleKomponener.setExpanded(true);
        lagringsenheter.setExpanded(true);
        mus.setExpanded(true);
        prosssor.setExpanded(true);
        skjermer.setExpanded(true);
        skjermkort.setExpanded(true);
        tastaturer.setExpanded(true);

        return alleKomponener;
    }

    @FXML
    public void fullforKjopAction() {
        if(HandlekurvData.getHandekurv().size()<=5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Konfigurasjonsfeil");
            alert.setHeaderText("Du har ikke konfigurert en hel datamaskin.");
            alert.setContentText("Du mangeler "+(6-HandlekurvData.getHandekurv().size())+" komponenter.");
            alert.showAndWait();
        }
        else{
            Ordre.genererOrdre();
        }


    }




    @FXML
    public void leggTilIHandekurv(){
        Komponent valgtKomponent = tabell.getSelectionModel().getSelectedItem().getValue();
        //Komponent nyVare = new Komponent(valgtKomponent.getVarenr(), (valgtKomponent.getVaremerke()+" "+valgtKomponent.getModell()), valgtKomponent.getPris(), valgtKomponent.getClass().getSimpleName());

        boolean duplikat = false;

        for(Komponent enKomponent : HandlekurvData.getHandekurv()){
            if(enKomponent.getClass().getSimpleName().equals(valgtKomponent.getClass().getSimpleName())){
                enKomponent = tabell.getSelectionModel().getSelectedItem().getValue();
                duplikat = true;
                break;
            }
        }
        if(duplikat==true){
            duplikater(valgtKomponent);
        }

        if(duplikat==false) {
            HandlekurvData.nyVare(valgtKomponent);
            tableHandekurv.refresh();
        }
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlkurv());

    }

    public void duplikater(Komponent nyVare){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Duplikater funnet");
        alert.setHeaderText(nyVare.getClass().getSimpleName()+" har du allerde konfigurert.\n\nVil du erstatte komponenten med "+nyVare.getVaremerke()+" "+nyVare.getModell()+"?");
        alert.setContentText("");
        alert.showAndWait();
        if(alert.getResult().getButtonData().isDefaultButton()==true){
            HandlekurvData.slettType(nyVare.getClass().getSimpleName());
            HandlekurvData.nyVare(nyVare);
            tableHandekurv.refresh();
        }

    }

    @FXML
    public void valgtKomponent(){
        komponentinfo.setVisible(true);
        NyttKjopKomponentinfoViewData.OppdaterView(tabell.getSelectionModel().getSelectedItem().getValue());
        komponentinfo.refresh();
    }


    @FXML
    public void slettHandlekurvAction(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Slett handlekur");
        alert.setHeaderText("Er du sikker på du vil slette hele varekurven?");
        alert.setContentText("Slettingen kan ikke angres");
        alert.showAndWait();
        if(alert.getResult().getButtonData().isDefaultButton()==true){
            HandlekurvData.getHandekurv().clear();
            HandlekurvData.setSumHandlkurv(0.0);
            tableHandekurv.refresh();
            lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlkurv());
        }

    }

    @FXML
    public void tilbakeAction() throws Exception {
        App.setRoot("kundeView/dashboardKunde");
    }

    @FXML
    public void slettValgtVareAction(){
        Komponent slettVare = (Komponent) tableHandekurv.getSelectionModel().getSelectedItem();
        HandlekurvData.getHandekurv().remove(slettVare);
        HandlekurvData.setSumHandlkurv(HandlekurvData.getSumHandlkurv() - slettVare.getPris());
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlkurv());
        tableHandekurv.refresh();
    }


    public void initialize() {
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlkurv());
        coHandlekurvPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        collection.hentKomponenttype(tableHandekurv);
        collection2.hentKomponentinfo(komponentinfo);

        coVaremerke.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String> param) {
                return param.getValue().getValue().getSSPVaremerke();
            }
        });



        coModell.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String> param) {
                return param.getValue().getValue().getSSPModell();
            }
        });

        coPris.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, Double> param) {
                return param.getValue().getValue().getSSPPris();
            }
        });

        tabell.setRoot(getModel());
        //tabell.setShowRoot(false);
    }
}

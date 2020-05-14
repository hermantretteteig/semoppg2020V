package org.example.kundeController;

import data.HandlekurvData;
import data.KomponentData;
import data.NyttKjopKomponentinfoViewData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

import java.io.IOException;

public class NyttKjopController {

    @FXML
    private TreeTableView<models.komponent.Komponent> tabell;

    @FXML
    private TableView tableHandekurv, komponentinfo;

    @FXML
    private TreeTableColumn<models.komponent.Komponent, String> coVaremerke, coModell;
    @FXML
    private TreeTableColumn<models.komponent.Komponent, Double> coPris;

    @FXML
    private TableColumn coHandlekurvNavn, coHandlekurvPris;

    @FXML
    private Label lblTotalpris;

    private HandlekurvData collection = new HandlekurvData();
    private NyttKjopKomponentinfoViewData collection2 = new NyttKjopKomponentinfoViewData();

    /*
    Alle komponentene som er tilgjengelig vises i et hierarki, der de ulike type komponetenene
    er gruppert.
     */
    public static TreeItem<models.komponent.Komponent> genererTreeItem()
    {
        //Oppretter treeItems som brukes for å sortere komponentene
        TreeItem<models.komponent.Komponent> lagringsenheter = new TreeItem<>(new models.komponent.Komponent("", "Lagringsenheter", "", 0));
        TreeItem<models.komponent.Komponent> mus = new TreeItem<>(new models.komponent.Komponent("", "Mus", "", 0));
        TreeItem<models.komponent.Komponent> prosssor = new TreeItem<>(new models.komponent.Komponent("", "Prosessorer", "", 0));
        TreeItem<models.komponent.Komponent> skjermer = new TreeItem<>(new models.komponent.Komponent("", "Skjermer", "", 0));
        TreeItem<models.komponent.Komponent> skjermkort = new TreeItem<>(new models.komponent.Komponent("", "Skjermkort", "", 0));
        TreeItem<models.komponent.Komponent> tastaturer = new TreeItem<>(new models.komponent.Komponent("", "Tastaturer", "", 0));

        //Roteten alle komponetene linkes til
        TreeItem<models.komponent.Komponent> alleKomponener = new TreeItem<>(new models.komponent.Komponent("", "Komponenter", "", 0));

        /*
        Komponentene må sorteres i de ulike gruppene/treeitem. Dette gjøres ved å
        gå igjennom komponentlisten og sortere de i grupper ut fra objektes SimpleName
         */
        for(models.komponent.Komponent enKompoent : KomponentData.getKomponenter()){

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

        //De ulike gruppene/treeitem legges under hovedgruppen komponenter
        alleKomponener.getChildren().setAll(prosssor, skjermkort, lagringsenheter, skjermer, mus, tastaturer);

        //Setter gruppene utvidet/åpne i viewet
        alleKomponener.setExpanded(true);
        lagringsenheter.setExpanded(true);
        mus.setExpanded(true);
        prosssor.setExpanded(true);
        skjermer.setExpanded(true);
        skjermkort.setExpanded(true);
        tastaturer.setExpanded(true);

        /*Returnerer et TreeItem, som nå er gruppert/bygget opp etter
         Alle komponenter --> Type komponent --> En komponent */
        return alleKomponener;
    }

    //Metode som legger til komponenten kunden har valgt i handlekurven
    @FXML
    public void leggTilIHandekurv(ActionEvent event){
        //Finner komponenten brukeren har valgt
        Komponent valgtKomponent = tabell.getSelectionModel().getSelectedItem().getValue();

        boolean duplikat = false;

        /*Det er kun mulig å legge til en type av hver komponent i handlekurven, for å forhindre
        at brukeren f. eks kjøper to prosessorer. Dette gjøres ved å gå igjennom handlekurven
        å se om et objekt med samme SimpleName eksiterer.
         */
        for(Komponent enKomponent : HandlekurvData.getHandlekurv()){
            if(enKomponent.getClass().getSimpleName().equals(valgtKomponent.getClass().getSimpleName())){
                enKomponent = tabell.getSelectionModel().getSelectedItem().getValue();
                duplikat = true;
                break;
            }
        }
        //Hvis det finnes allerede kalles en metode for å informere om dette
        if(duplikat==true){
            duplikater(valgtKomponent);
        }

        //Hvis komponententypen ikke allerede eksiterer i handlekurven, blir den lagt til
        if(duplikat==false && valgtKomponent.getPris()!=0.0) {
            HandlekurvData.nyVare(valgtKomponent);
            tableHandekurv.refresh();
        }
        //Oppdaterer totalprisen til handlekurven ved å kalle en metode som summerer handlekurven
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlekurv());

    }

    //Varsel som vises når duplikater blir funnet i handlekurven
    public void duplikater(Komponent nyVare){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Duplikater funnet");
        alert.setHeaderText(nyVare.getClass().getSimpleName()+" har du allerde konfigurert.\n\nVil du erstatte komponenten med "+nyVare.getVaremerke()+" "+nyVare.getModell()+"?");
        alert.setContentText("");
        alert.showAndWait();
        //Brukeren får valget om han/hun vil erstatte komponenten som ligger i handlekurven
        //Hvis han/hun ønsker dette blir den ny komponenten lagt til i handlekurven.
        if(alert.getResult().getButtonData().isDefaultButton()==true){
            //Sletter ekisterende
            HandlekurvData.slettKomponent(nyVare.getClass().getSimpleName());
            //Legger til den nye
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

    //Metode som sletter alt innhold i handlekurven
    @FXML
    public void slettHandlekurvAction(ActionEvent event){
        //Ber brukeren bekrefte at han/hun faktisk ønsker å slette hele handlekurven
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Slett handlekur");
        alert.setHeaderText("Er du sikker på du vil slette hele varekurven?");
        alert.setContentText("Slettingen kan ikke angres");
        alert.showAndWait();
        //Hvis brukeren bekrefter dette slettes handlekurven og summen i handlekurv til kr 0.
        if(alert.getResult().getButtonData().isDefaultButton()==true){
            HandlekurvData.getHandlekurv().clear();
            HandlekurvData.setSumHandlekurv(0.0);
            tableHandekurv.refresh();
            lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlekurv());
        }

    }

    //Metode som generer en ordre av handlekurv
    @FXML
    public void fullforKjopAction(ActionEvent event) throws IOException, CloneNotSupportedException {
        //Sjekker at handlekurv ikke mangler noen komponenter
        if(HandlekurvData.getHandlekurv().size()<=5){
            //Viser feilmelding hvis den er for liten
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Konfigurasjonsfeil");
            alert.setHeaderText("Du har ikke konfigurert en hel datamaskin.");
            alert.setContentText("Du mangeler "+(6-HandlekurvData.getHandlekurv().size())+" komponenter.");
            alert.showAndWait();
        }
        //Hvis den har riktig lengde
        else{
            //Ber brukeren bekrefte at han/hun faktisk vil fullføre kjøpet
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Fullfør kjøp");
            alert.setHeaderText("Du er i ferd med å fullføre kjøpet.\nVil du fortsette?");
            alert.showAndWait();
            //Hvis brukeren fullfører
            if(alert.getResult().getButtonData().isDefaultButton()==true){
                //Kaller metode som genererer en ordre ut av handlekurven
                Ordre.genererOrdreAvHandlekurv();
                //Setter summen i handlekurven til kr. 0
                HandlekurvData.setSumHandlekurv(0.0);

                //Viser bekreftelsemelding på at kjøpet er fullført
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Kjøp registert");
                info.setHeaderText("Ditt kjøp er registert.");
                info.showAndWait();
                App.setRoot("kundeView/dashboardKunde");
            }
        }
    }

    //Knapp for å komme tilbake til dashboard
    @FXML
    public void tilbakeAction(ActionEvent event) throws Exception {
        App.setRoot("kundeView/dashboardKunde");
    }

    //Mulighet til å slette en komponent i handlekurven
    @FXML
    public void slettValgtVareAction(ActionEvent event){
        Komponent slettVare = (Komponent) tableHandekurv.getSelectionModel().getSelectedItem();
        HandlekurvData.getHandlekurv().remove(slettVare);
        HandlekurvData.setSumHandlekurv(HandlekurvData.getSumHandlekurv() - slettVare.getPris());
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlekurv());
        tableHandekurv.refresh();
    }


    public void initialize() {
        //Generer prisen til handlekurven ut fra de komponentene som eksiterer i handlekurven
        lblTotalpris.setText("Totalpris: "+ HandlekurvData.getSumHandlekurv());
        //Konverterer prisen til string
        coHandlekurvPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //Setter lister til tabellene
        collection.hentKomponenttype(tableHandekurv);
        collection2.hentKomponentinfo(komponentinfo);

        /*
        Under er tre metoder som henter tre ulike attributter som vises i komponentviewet.
         */
        coVaremerke.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getVaremerke());
            }
        });


        coModell.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getModell());
            }
        });

        coPris.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<models.komponent.Komponent, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TreeTableColumn.CellDataFeatures<models.komponent.Komponent, Double> param) {
                return param.getValue().getValue().getSSPPris();
            }
        });

        //Setter inn TreeItem til treeitem-viewet
        tabell.setRoot(genererTreeItem());
    }
}

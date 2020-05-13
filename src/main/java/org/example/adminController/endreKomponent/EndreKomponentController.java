package org.example.adminController.endreKomponent;

import javafx.beans.property.SimpleBooleanProperty;
import logikk.Advarsel;
import validering.DesimaltallCheck;
import validering.LengeCheck;
import validering.HeltallCheck;
import data.KomponentData;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.komponent.*;
import org.example.App;

import  javafx.scene.control.cell.TextFieldTableCell;

public class EndreKomponentController {

    public TableView tableView;
    public TableColumn coTrodlos;
    public TableColumn coNumpad;
    public TableColumn coPris;


    public ChoiceBox choKomponentvelger;

    //Lagrinsenhet
    public TableColumn coGb;
    public TableColumn coFormat;
    public TableColumn coLesehastighet;
    public TableColumn coSkrivehastighet;

    //Mus
    public TableColumn coMusTrodlos;
    public TableColumn coFarge;

    //Prosessor
    public TableColumn coKjerner;
    public TableColumn coKlokkehastighet;

    //Sjerm
    public TableColumn coHoyde;
    public TableColumn coBredde;
    public TableColumn co4K;

    //Type
    public TableColumn coType;

    //Skjermkort
    public TableColumn coSkKlokkehastighet;
    public TableColumn coMinne;


    //Filtrering
    public TextField txtPrisFra;
    public TextField txtPrisTil;




    private KomponentData collection = new KomponentData();




    @FXML
    public void tilbakeAction() throws Exception {
        App.setRoot("adminview/dashboardAdmin");


    }

    @FXML
    public void filtrerAction(){
        if(DesimaltallCheck.desimaltallCheck(txtPrisFra.getText())==false || DesimaltallCheck.desimaltallCheck(txtPrisTil.getText()) == false){
            Advarsel.informasjonsAlert("Ugyldige verdier", "Prisene er ikke gyldig", "Prøv på nytt!");
        }
        else {
            double prisFra = Double.parseDouble(txtPrisFra.getText());
            double prisTil = Double.parseDouble(txtPrisTil.getText());
            collection.sorterEtterPris(tableView, prisFra, prisTil, choKomponentvelger.getValue().toString());
        }
    }

    @FXML
    public void fjernFilterAction(){
        collection.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());
    }

    @FXML
    public void hentAction() throws Exception {
        txtPrisFra.setText("");
        txtPrisTil.setText("");
        SkjulAlleEkstrakolonner();
        collection.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }


    public void initialize() {
        //Konverterer double og integer til string, slik at disse verdiene kan bli endres i tekstfelt
        coPris.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coGb.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coKjerner.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coBredde.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coHoyde.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coSkKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coMinne.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));


        LagBindingFraDataTilTabell();

        //Setter startvisning til å være lagringsenhet
        choKomponentvelger.setValue("Lagringsenhet");

        SkjulAlleEkstrakolonner();

        //Generer kolonner som gjelder for "Lagringsenhet"
        collection.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }

    /*
    Under kommmer en rekke metoder for endring av data i tabellen. Metodene tar inn cellen/verdien som er i endring
    som parameter. Deretter valideres verdien i en metode som returnerer true/false. Dette svaret
    brukes av metoden "nyFeil" som enten returnere false og viser dialogvindu med feilinformasjon,
    eller returnerer "true" som oppdaterer objektet med den nye verdien.
     */


    public void VareMerkeEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(nyFeil("For kort varemerkenavn. Minst to tegn", LengeCheck.lengdeCheck(event.getNewValue())) == true) {
            event.getRowValue().setVaremerke(event.getNewValue());
            tableView.refresh();
        }
    }

    public void PrisEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            event.getRowValue().setPris(event.getNewValue());
        }
        else {
            event.getRowValue().setPris(event.getOldValue());
        }
        tableView.refresh();
    }

    public void ModellEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(nyFeil("For kort modelnavn. Minst to tegn", LengeCheck.lengdeCheck(event.getNewValue())) == true) {
            event.getRowValue().setModell(event.getNewValue());
            tableView.refresh();
        }
    }

    //Tastatur
    public void NumpadEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Tastatur) event.getRowValue()).setNumpad(event.getNewValue());
    }

    public void TrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Tastatur) event.getRowValue()).setTrodlos(event.getNewValue());
    }

    //Lagringsenhet
    public void FormatEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        ((Lagringsenhet) event.getRowValue()).setFormat(event.getNewValue());
    }

    public void GbEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Lagringsenhet) event.getRowValue()).setGb(event.getNewValue());
        }
        else{
            ((Lagringsenhet) event.getRowValue()).setGb(event.getOldValue());
        }
        tableView.refresh();
    }

    public void SkrivehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(nyFeil("Må kun inneholde tall", HeltallCheck.heltallCheck(event.getNewValue())) == true) {
            ((Lagringsenhet) event.getRowValue()).setSkriveHastighet(event.getNewValue());
            tableView.refresh();
        }
    }

    public void LesehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(nyFeil("Må kun inneholde tall", HeltallCheck.heltallCheck(event.getNewValue())) == true) {
            ((Lagringsenhet) event.getRowValue()).setLeseHastighet(event.getNewValue());
            tableView.refresh();
        }
    }

    //Mus
    public void MusTrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Mus) event.getRowValue()).setTrodlos(event.getNewValue());
    }

    public void FargeEdit(TableColumn.CellEditEvent<Komponent, String> event){
        ((Mus) event.getRowValue()).setFarge(event.getNewValue());
    }

    //Prosessor
    public void KjernerEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Prosessor) event.getRowValue()).setAntallKjerner(event.getNewValue());
        }
        else{
            ((Prosessor) event.getRowValue()).setAntallKjerner(event.getOldValue());
        }
        tableView.refresh();
    }

    public void KlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Prosessor) event.getRowValue()).setKlokkehastighet(event.getNewValue());
        }
        else{
            ((Prosessor) event.getRowValue()).setKlokkehastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    //Skjerm
    public void HoydeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Skjerm) event.getRowValue()).setPixelHoyde(event.getNewValue());
        }
        else{
            ((Skjerm) event.getRowValue()).setPixelHoyde(event.getOldValue());
        }
        tableView.refresh();
    }

    public void BreddeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Skjerm) event.getRowValue()).setPixelBredde(event.getNewValue());
        }
        else{
            ((Skjerm) event.getRowValue()).setPixelBredde(event.getOldValue());
        }
        tableView.refresh();
    }

    //Skjermkort
    public void SkKlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Skjermkort) event.getRowValue()).setKlokkehastighet(event.getNewValue());
        }
        else{
            ((Skjermkort) event.getRowValue()).setKlokkehastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    public void MinneEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(nyFeil("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Skjermkort) event.getRowValue()).setMinne(event.getNewValue());
        }
        else{
            ((Skjermkort) event.getRowValue()).setMinne(event.getOldValue());
        }
        tableView.refresh();
    }

    public void SkjulAlleEkstrakolonner() {
        //Tastatur
        coTrodlos.setVisible(false);
        coNumpad.setVisible(false);

        //Lagringsenhet
        coGb.setVisible(false);
        coFormat.setVisible(false);
        coLesehastighet.setVisible(false);
        coSkrivehastighet.setVisible(false);

        //Mus
        coMusTrodlos.setVisible(false);
        coFarge.setVisible(false);

        //Prosessor
        coKjerner.setVisible(false);
        coKlokkehastighet.setVisible(false);

        //Skjerm
        coHoyde.setVisible(false);
        coBredde.setVisible(false);
        co4K.setVisible(false);

        //Skjermkort
        coSkKlokkehastighet.setVisible(false);
        coMinne.setVisible(false);

        //Type
        coType.setVisible(false);
    }

    public void visEkstrakolonner(String type) {

        switch (type) {
            case "Lagringsenhet":
                coGb.setVisible(true);
                coFormat.setVisible(true);
                coLesehastighet.setVisible(true);
                coSkrivehastighet.setVisible(true);
                break;
            case "Tastatur":
                coTrodlos.setVisible(true);
                coNumpad.setVisible(true);
                break;
            case "Mus":
                coMusTrodlos.setVisible(true);
                coFarge.setVisible(true);
                break;
            case "Prosessor":
                coKjerner.setVisible(true);
                coKlokkehastighet.setVisible(true);
                break;
            case "Skjerm":
                coHoyde.setVisible(true);
                coBredde.setVisible(true);
                co4K.setVisible(true);
                break;
            case "Skjermkort":
                coSkKlokkehastighet.setVisible(true);
                coMinne.setVisible(true);
                break;
            case "Vis alle":
                coType.setVisible(true);
                break;
            default:
        }
    }

    public static boolean nyFeil(String msg, Boolean feil){
        if (feil == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wooops!");
            alert.setHeaderText(msg);
            alert.setContentText("Prøv igjen!");
            alert.showAndWait();
            return false;
        }
            return true;
        }

    /*
    Metoden under lager bindinger til de datane som krever noe annet enn tekstfelt. I dette tilfellet er det
    valgvelger og sjekkboks.
     */
    private void LagBindingFraDataTilTabell() {
        coTrodlos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tastatur,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Tastatur, Boolean> event)
            {
                return new SimpleBooleanProperty(event.getValue().getTrodlos());}
        });

        coNumpad.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tastatur,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Tastatur, Boolean> event)
            {
                return new SimpleBooleanProperty(event.getValue().getNumpad());}
        });
        co4K.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Skjerm,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Skjerm, Boolean> event)
            {
                return new SimpleBooleanProperty(event.getValue().getMin4K());}
        });
        coMusTrodlos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Mus,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Mus, Boolean> event)
            {
                return new SimpleBooleanProperty(event.getValue().getTrodlos());}
        });


        coFormat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Lagringsenhet,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Lagringsenhet, String> event) {
                return event.getValue().getSpFormat();
            }
        });

        coFormat.setCellFactory(ComboBoxTableCell.<Lagringsenhet, String>forTableColumn("SSD 2.5", "SDD M.2", "SSD mSATA", "HDD"));
        coNumpad.setCellFactory( CheckBoxTableCell.forTableColumn(coNumpad) );
        coTrodlos.setCellFactory( CheckBoxTableCell.forTableColumn(coTrodlos) );
        coFarge.setCellFactory(ComboBoxTableCell.<Lagringsenhet, String>forTableColumn("Grå", "Svart", "Blå", "Brun", "Rose", "Hvit", "Oransje", "Rød"));
        co4K.setCellFactory( CheckBoxTableCell.forTableColumn(co4K) );
        coMusTrodlos.setCellFactory( CheckBoxTableCell.forTableColumn(coMusTrodlos) );

    }

    public static class EgendefinertIntegerConverterer extends IntegerStringConverter {
        @Override
        public Integer fromString(String innputverdi) {
            if(HeltallCheck.heltallCheck(innputverdi)==true){
                return Integer.parseInt(innputverdi);
            }
            return -1;
        }
    }

    public static class EgendefinertDoubleConverter extends DoubleStringConverter {
        @Override
        public Double fromString(String innputverdi) {
            if(HeltallCheck.heltallCheck(innputverdi)==true) {
                return Double.parseDouble(innputverdi);
            }
            return -1.0;
        }
    }
}


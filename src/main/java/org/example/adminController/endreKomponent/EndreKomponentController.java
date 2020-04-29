package org.example.adminController.endreKomponent;

import validering.ValiKomponent;
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

    //Skjermkort
    public TableColumn coSkKlokkehastighet;
    public TableColumn coMinne;

    private KomponentData collection = new KomponentData();

    @FXML
    public void tilbakeAction() throws Exception {
        App.setRoot("adminView/dashboardAdmin");
    }

    @FXML
    public void hentAction() throws Exception {
        SkjulAlleEkstrakolonner();
        collection.hentLagrinsenheter(tableView, choKomponentvelger.getValue().toString());
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }


    public void initialize() {
        //Konverterer double og integer til string, slik at disse verdiene kan bli endres i tekstfelt
        coPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        coGb.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coKjerner.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        coBredde.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coHoyde.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coSkKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        coMinne.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        LagBindingFraDataTilTabell();

        //Setter startvisning til å være lagringsenhet
        choKomponentvelger.setValue("Lagringsenhet");

        SkjulAlleEkstrakolonner();

        //Generer kolonner som gjelder for "Lagringsenhet"
        collection.hentLagrinsenheter(tableView, choKomponentvelger.getValue().toString());
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }

    /*
    Under kommmer en rekke metoder for endring av data i tabellen. Metodene tar inn cellen/verdien som er i endring
    som parameter. Deretter valideres verdien i en metode som returnerer true/false. Dette svaret
    brukes av metoden "nyFeil" som enten returnere false og viser dialogvindu med feilinformasjon,
    eller returnerer "true" som oppdaterer objektet med den nye verdien.
     */


    public void VareMerkeEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        event.getRowValue().setVaremerke(event.getNewValue());
    }

    public void PrisEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        event.getRowValue().setPris(event.getNewValue());
    }

    public void ModellEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        event.getRowValue().setModell(event.getNewValue());
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
        ((Lagringsenhet) event.getRowValue()).setGb(event.getNewValue());
    }

    public void SkrivehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        ((Lagringsenhet) event.getRowValue()).setSkriveHastighet(event.getNewValue());
    }

    public void LesehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        ((Lagringsenhet) event.getRowValue()).setLeseHastighet(event.getNewValue());
    }

    //Mus
    public void MusTrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Mus) event.getRowValue()).setTrodlos(event.getNewValue());
    }

    public void FargeEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        ((Mus) event.getRowValue()).setFarge(event.getNewValue());
    }

    //Prosessor
    public void KjernerEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        ((Prosessor) event.getRowValue()).setAntallKjerner(event.getNewValue());
    }

    public void KlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        ((Prosessor) event.getRowValue()).setKlokkehastighet(event.getNewValue());
    }

    //Skjerm
    public void HoydeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        ((Skjerm) event.getRowValue()).setPixelHoyde(event.getNewValue());
        tableView.refresh();
    }

    public void BreddeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        ((Skjerm) event.getRowValue()).setPixelBredde(event.getNewValue());
        tableView.refresh();
    }

    //Skjermkort
    public void SkKlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        ((Skjermkort) event.getRowValue()).setKlokkehastighet(event.getNewValue());
    }

    public void MinneEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        ((Skjermkort) event.getRowValue()).setMinne(event.getNewValue());
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
                return event.getValue().getBpTrodlos();}
        });

        coNumpad.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tastatur,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Tastatur, Boolean> event)
            {
                return event.getValue().getBpNumpad();}
        });
        co4K.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Skjerm,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Skjerm, Boolean> event)
            {
                return event.getValue().getBpMin4K();}
        });
        coMusTrodlos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Mus,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Mus, Boolean> event)
            {
                return event.getValue().getBpMusTrodlos();}
        });


        coFormat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Lagringsenhet,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Lagringsenhet, String> event) {
                return event.getValue().getSpFormat();
            }
        });

        coFormat.setCellFactory(ComboBoxTableCell.<Lagringsenhet, String>forTableColumn("SSD 2.5", "SDD M.2", "SSD mSATA", "HDD"));
        coNumpad.setCellFactory( CheckBoxTableCell.forTableColumn(coNumpad) );
        coTrodlos.setCellFactory( CheckBoxTableCell.forTableColumn(coTrodlos) );
        co4K.setCellFactory( CheckBoxTableCell.forTableColumn(co4K) );
        coMusTrodlos.setCellFactory( CheckBoxTableCell.forTableColumn(coMusTrodlos) );

    }
}


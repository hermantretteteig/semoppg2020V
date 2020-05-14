package org.example.adminController;

import data.KundeData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import models.brukere.Kunde;
import org.example.App;
import validering.*;

public class EndreKunde {

        public TableView tableView;


        //Lagrinsenhet
        public TableColumn coFornavn;
        public TableColumn coEtternavn;
        public TableColumn coBrukernavn;
        public TableColumn coPassord;
        public TableColumn coKundenummer;
        public TableColumn coEpost;


        private KundeData collection = new KundeData();

        @FXML
        public void tilbakeAction() throws Exception {
            App.setRoot("adminView/dashboardAdmin");
        }


        public void initialize() {
            collection.hentAlleKunder(tableView);
            LagBindingFraDataTilTabell();
        }


        public void FornavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(nyFeil("Må kun inneholde bokstaver", Check.bokstavercheck(event.getNewValue()))==true){
            event.getRowValue().setFornavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void EtternavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(nyFeil("Må kun inneholde bokstaver", Check.bokstavercheck(event.getNewValue()))==true){
            event.getRowValue().setEtternavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void BrukernavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(nyFeil("For kort brukernavn. Minst to tegn", Check.lengdeCheck(event.getNewValue()))==true){
            event.getRowValue().setBrukernavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void PassordEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(nyFeil("Ugyldig passord! \nMå være små og store bokstaver, \nminst 8 tegn og inneholde tall", Check.passordchecker(event.getNewValue()))==true){
            event.getRowValue().setPassord(event.getNewValue()); }
            tableView.refresh();
        }

        public void EpostEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(nyFeil("Du har skrevet inn en ugyldig epost", Check.epostchecker(event.getNewValue()))==true){
            event.getRowValue().setEpost(event.getNewValue()); }
            tableView.refresh();
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

        private void LagBindingFraDataTilTabell() {
            coFornavn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kunde,String>, ObservableValue<String>>()
            {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Kunde, String> event)
                {
                    return new SimpleStringProperty(event.getValue().getFornavn());}
            });

            coEtternavn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kunde,String>, ObservableValue<String>>()
            {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Kunde, String> event)
                {
                    return new SimpleStringProperty(event.getValue().getEtternavn());}
            });
            coBrukernavn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kunde,String>, ObservableValue<String>>()
            {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Kunde, String> event)
                {
                    return new SimpleStringProperty(event.getValue().getBrukernavn());}
            });
            coEpost.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kunde,String>, ObservableValue<String>>()
            {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Kunde, String> event)
                {
                    return new SimpleStringProperty(event.getValue().getEpost());}
            });


        }
    }



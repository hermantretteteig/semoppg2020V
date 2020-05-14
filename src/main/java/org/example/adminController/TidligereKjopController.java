package org.example.adminController;

import data.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

import data.OrdreData;
import data.NyttKjopKomponentinfoViewData;
import data.ValgtOrdreSinDatamaskinData;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import models.kjop.Ordre;
import models.komponent.Komponent;
import org.example.App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TidligereKjopController {
    @FXML
    public TableView<Ordre> ordre;
    public TableView komponentinfo;
    public TableView<Komponent> valgtDatamaskin;

    @FXML
    public TableColumn coKunde;
    public TableColumn coDato;

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
        App.setRoot("adminView/dashboardAdmin");
    }


    public void initialize() {
        collection1.hentKomponentinfo(komponentinfo);
        alleOrdre.hentAlleOrdre(ordre);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*coDato.setCellFactory(tc -> new TableCell<Ordre, String>() {
            @Override
            protected void updateItem(String date, boolean empty) {
                System.out.println(date);
                LocalDate today = LocalDate.parse(date, formatter);
                super.updateItem(date, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(formatter.format(today));
                }
            }
        });*/

    coKunde.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordre, String>,
            ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Ordre, String> data){
            Kunde valgtKunde = KundeData.getKunde(data.getValue().getKundenr());

            return new SimpleStringProperty(valgtKunde.getFornavn()+" "+valgtKunde.getEtternavn());
        }
    });


    }

}

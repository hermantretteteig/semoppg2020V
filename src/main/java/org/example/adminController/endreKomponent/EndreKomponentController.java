package org.example.adminController.endreKomponent;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.komponent.Komponent;
import models.komponent.Tastatur;
import org.example.App;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import  javafx.scene.control.cell.TextFieldTableCell;

public class EndreKomponentController {

    public TableView tableView;
    public TableColumn coLesehastighet;
    public TableColumn coTrodlos;
    public TableColumn coNumpad;
    public TableColumn coPris;

    private KomponentData collection = new KomponentData();

    @FXML
    public void tilbakeAction() throws Exception{
        App.setRoot("adminView/dashboardAdmin");
        //coLesehastighet.setVisible(false);
    }


    public void initialize() {
        //tableView.setEditable(true);
        //tableView.setEditable(true);
        //coLesehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coTrodlos.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        coNumpad.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        coPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        collection.attachTableView(tableView);
    }


    @FXML
    public void VarenrEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        event.getRowValue().setVarenr(event.getNewValue());
    }

    public void VareMerkeEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        event.getRowValue().setVaremerke(event.getNewValue());
    }

    public void PrisEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        event.getRowValue().setPris(event.getNewValue());
    }

    public void ModellEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        event.getRowValue().setModell(event.getNewValue());
    }


    @FXML
    public void NumpadEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Tastatur) event.getRowValue()).setNumpad(event.getNewValue());
    }

    @FXML
    public void TrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        //event.getRowValue().setVarenr(event.getNewValue());
    }

    @FXML
    public void LesehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        //event.getRowValue().setVarenr(event.getNewValue());
    }


}

package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Tore.Test;
import org.example.App;

public class NyLagringsenhetController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblFormatFeil;
    public Label lblLagringsenhetFeil;
    public Label lblLesehastighetFeil;
    public Label lblSkrivehastighetFeil;


    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choFormat;
    public TextField txtLagringskapasitet;
    public TextField txtSkrivehastighet;
    public TextField txtLesehastighet;


    @FXML
    public void leggTilAction() throws Exception{
        lblVaremerkeFeil.setText("Test");
        lblModellFeil.setText("Test");
        lblPrisFeil.setText("Test");
        lblFormatFeil.setText("Test");
        lblLagringsenhetFeil.setText("Test");
        lblLesehastighetFeil.setText("Test");
        lblSkrivehastighetFeil.setText("Test");

        /*
        Dette er ikke noen ferdig løsning, men test for å se om det fungerer.
        */
        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        //double pris = Double.parseDouble(txtPris.getText());


        //Lagringsenhet nyLagringsenhet = new Lagringsenhet();
        //KomponentData.leggTilKomponent(nyLagringsenhet);

        //Rooter tilslutt til oversiktview

        //Hvis felter ok:
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

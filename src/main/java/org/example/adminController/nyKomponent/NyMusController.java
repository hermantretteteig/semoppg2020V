package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.komponent.Mus;
import models.komponent.Skjermkort;
import org.example.App;

public class NyMusController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblTrodlosFeil;
    public Label lblFargeFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choTrodlos;
    public ColorPicker colFarge;



    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("test");
        lblModellFeil.setText("test");
        lblPrisFeil.setText("test");
        lblTrodlosFeil.setText("test");
        lblFargeFeil.setText("test");


        /*

        KODE SOM VALIDERER OG LEGGER TIL SKJERMKORT I LISTE

         */

        /*
        Dette er ikke noen ferdig løsning, men test for å se om det fungerer.
        */
        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());


        //Mus nyMus = new Mus();
        //KomponentData.leggTilKomponent(nyMus);

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

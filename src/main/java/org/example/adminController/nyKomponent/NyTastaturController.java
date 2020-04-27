package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.App;

public class NyTastaturController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;


    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;


    @FXML
    public void leggTilAction() throws Exception{
        /*

        KODE SOM VALIDERER OG LEGGER TIL SKJERMKORT I LISTE

         */

        /*
        Dette er ikke noen ferdig løsning, men test for å se om det fungerer.
        */
        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());

        lblVaremerkeFeil.setText("Test");
        lblModellFeil.setText("Test");
        lblPrisFeil.setText("Test");


        //Tastatur nyTastatur = new Tastatur();
        //KomponentData.leggTilKomponent(nyTastatur);

        //Rooter tilslutt til oversiktview
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

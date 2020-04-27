package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.App;

public class NyProsessorController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblKjernerFeil;
    public Label lblKlokkehastighetFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtKjerner;
    public TextField txtKlokkehastighet;


    @FXML
    public void leggTilAction() throws Exception{
        /*

        KODE SOM VALIDERER OG LEGGER TIL SKJERMKORT I LISTE

         */

        lblVaremerkeFeil.setText("test");
        lblModellFeil.setText("test");
        lblPrisFeil.setText("test");
        lblKjernerFeil.setText("test");
        lblKlokkehastighetFeil.setText("test");

        /*
        Dette er ikke noen ferdig løsning, men test for å se om det fungerer.
        */

        /*String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());*/


        //Prosessor nyProsessor = new Prosessor();
        //KomponentData.leggTilKomponent(nyProsessor);

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

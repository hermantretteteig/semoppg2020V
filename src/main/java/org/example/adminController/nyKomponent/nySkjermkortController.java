package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.komponent.Skjermkort;
import org.example.App;

public class nySkjermkortController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblKlokkehastighetFeil;
    public Label lblMinneFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtKlokkehastighet;
    public TextField txtMinne;

    //TODO, husk å fjern
    public Skjermkort skjermkort = new Skjermkort("null", "null", "null", 2222, 2,8);

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
        int klokkehastighet = Integer.parseInt(txtKlokkehastighet.getText());
        int minne = Integer.parseInt(txtMinne.getText());

        skjermkort = new Skjermkort("metode", varemerke, modell, pris, klokkehastighet, minne);
        KomponentData.leggTilKomponent(skjermkort);

        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

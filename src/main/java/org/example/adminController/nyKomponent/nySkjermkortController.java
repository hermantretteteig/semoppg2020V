package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    @FXML
    public void leggTilAction() throws Exception{
        /*

        KODE SOM VALIDERER OG LEGGER TIL SKJERMKORT I LISTE

         */



        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.NyKomponentAlert;
import models.komponent.Skjermkort;
import org.example.App;
import validering.DesimaltallCheck;
import validering.LengeCheck;
import validering.HeltallCheck;
import java.io.IOException;

public class NySkjermkortController {

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

    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws IOException {
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws IOException {

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblKlokkehastighetFeil.setText("");
        lblMinneFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();
        String klokkehastighet = txtKlokkehastighet.getText();
        String minne = txtMinne.getText();


        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        //Validerer Varenummer

        //Validerer Varemerke
        if (LengeCheck.lengdeCheck(varemerke) == false) {
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if (LengeCheck.lengdeCheck(modell) == false) {
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if (DesimaltallCheck.desimaltallCheck(pris) == false) {
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Validerer klokkehastighet
        if (DesimaltallCheck.desimaltallCheck(klokkehastighet) == false) {
            lblKlokkehastighetFeil.setText("Må kun inneholde tall");
            check4 = false;
        }

        //Validerer Minne
        if (HeltallCheck.heltallCheck(minne) == false) {
            lblMinneFeil.setText("Må kun inneholde tall");
            check5 = false;
        }



        if (check1 && check2 && check3 && check4 && check5){
            Skjermkort nyttSkjermkort = new Skjermkort(varemerke,
                    modell,
                    Double.parseDouble(pris),
                    Double.parseDouble(klokkehastighet),
                    Integer.parseInt(minne));
            KomponentData.leggTilKomponent(nyttSkjermkort);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            NyKomponentAlert.visBekreftelse(varemerke, modell);
        }
    }
}

package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.NyKomponentAlert;
import models.komponent.Prosessor;
import org.example.App;
import validering.LengeCheck;
import validering.DesimaltallCheck;
import validering.HeltallCheck;

import java.io.IOException;

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


    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws IOException {

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblKjernerFeil.setText("");
        lblKlokkehastighetFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();
        String kjerner = txtKjerner.getText();
        String klokkehastighet = txtKlokkehastighet.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        //Validerer Varenummer


        //Validerer Varemerke
        if(LengeCheck.lengdeCheck(varemerke) == false){
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if(LengeCheck.lengdeCheck(modell) == false){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if(DesimaltallCheck.desimaltallCheck(pris) == false){
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Validerer Kjerner
        if(HeltallCheck.heltallCheck(kjerner) == false){
            lblKjernerFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Klokkehastighet
        if(DesimaltallCheck.desimaltallCheck(klokkehastighet) == false){
            lblKlokkehastighetFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        Prosessor nyProsessor = new Prosessor(varemerke, modell,
                Double.parseDouble(pris),
                Integer.parseInt(kjerner),
                Double.parseDouble(klokkehastighet));

        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nyProsessor);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            NyKomponentAlert.visBekreftelse(varemerke, modell);
        }
    }
}
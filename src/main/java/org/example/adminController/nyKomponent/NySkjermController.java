package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.NyKomponentAlert;
import models.komponent.Skjerm;
import org.example.App;
import validering.DesimaltallCheck;
import validering.LengeCheck;
import validering.HeltallCheck;

import java.io.IOException;

public class NySkjermController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblHoydeFeil;
    public Label lblBreddeFeil;
    public Label lbl4KFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtHoyde;
    public TextField txtBredde;
    public ChoiceBox cho4K;

    @FXML public javafx.scene.control.Button registrer;
    @FXML public  javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws IOException{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblHoydeFeil.setText("");
        lblBreddeFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();
        String hoyde = txtHoyde.getText();
        String bredde = txtBredde.getText();

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

        //Validerer Bredde
        if(HeltallCheck.heltallCheck(bredde) == false){
            lblBreddeFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Høyde
        if(HeltallCheck.heltallCheck(hoyde) == false){
            lblHoydeFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        Skjerm nySkjerm = new Skjerm(varemerke, modell, Double.parseDouble(pris),
                 Integer.parseInt(hoyde), Integer.parseInt(bredde));

        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nySkjerm);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            NyKomponentAlert.visBekreftelse(varemerke, modell);
        }
    }
}

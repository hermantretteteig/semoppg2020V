package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.Advarsel;
import models.komponent.Skjerm;
import org.example.App;
import validering.Check;

import java.io.IOException;

public class NySkjermController {

    //Oppretter tekstfelt ved feil-input
    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblHoydeFeil;
    public Label lblBreddeFeil;

    //Opprett inputfelt
    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtHoyde;
    public TextField txtBredde;

    @FXML public javafx.scene.control.Button registrer;
    @FXML public  javafx.scene.control.Button avslutt;

    //Dersom brukeren vil avlutte vises nyKomonentView
    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    //Legg til en ny komponent dersom alt i denne klassen er oppfylt
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

        //Validerer Varemerke
        if(Check.lengdeCheck(varemerke) == false){
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if(Check.lengdeCheck(modell) == false){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if(Check.desimaltallCheck(pris) == false){
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Validerer Bredde
        if(Check.heltallCheck(bredde) == false){
            lblBreddeFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Høyde
        if(Check.heltallCheck(hoyde) == false){
            lblHoydeFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        //Kun dersom check'ene er oppfylt lages det en ny skjerm
        if (check1 && check2 && check3 && check4 && check5){
            Skjerm nySkjerm = new Skjerm(varemerke, modell, Double.parseDouble(pris),
                    Integer.parseInt(hoyde), Integer.parseInt(bredde));
            KomponentData.leggTilKomponent(nySkjerm);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            Advarsel.informasjonsAlert("Skjerm registrert", varemerke +
                    " er registrert", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }
}

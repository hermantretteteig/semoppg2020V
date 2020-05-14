package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.Advarsel;
import models.komponent.Mus;
import org.example.App;
import validering.Check;


public class NyMusController {

    //Oppretter tekstfelt ved feil-input
    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblTrodlosFeil;
    public Label lblFargeFeil;

    //Opprett inputfelt
    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choTrodlos;
    public ChoiceBox choFarge;

    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    //Dersom brukeren vil avlutte vises nyKomonentView
    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    //Legg til en ny komponent dersom alt i denne metoden er oppfylt
    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblTrodlosFeil.setText("");
        lblFargeFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();

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
        //Validerer Trodlos
        if(choTrodlos.getValue() == null) {
            lblTrodlosFeil.setText("Må fylles ut");
            check4 = false;
        }
        boolean trodlos = false;
        if(choTrodlos.getValue().equals("Ja")) {
            trodlos = true;
        }

        //Kun dersom check'ene er oppfylt lages det en ny mus
        if (check1 && check2 && check3 && check4 && check5){
            Mus nyMus = new Mus(varemerke, modell, Double.parseDouble(pris), trodlos, choFarge.getValue().toString());
            KomponentData.leggTilKomponent(nyMus);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            Advarsel.informasjonsAlert("Mus registrert", varemerke +
                    " er registrert", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }

    public void initialize() {
        choFarge.setValue("Grå");
        choTrodlos.setValue("Ja");
    }
}

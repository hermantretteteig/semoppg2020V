package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.Advarsel;
import models.komponent.Lagringsenhet;
import org.example.App;
import validering.Check;

public class NyLagringsenhetController {

    //Opprett tekstfelt ved feil-input
    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblFormatFeil;
    public Label lblStorrelseFeil;
    public Label lblLesehastighetFeil;
    public Label lblSkrivehastighetFeil;

    //Opprett inputfelt
    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choFormat;
    public TextField txtLagringskapasitet;
    public TextField txtLesehastighet;
    public TextField txtSkrivehastighet;

    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    //Dersom brukeren vil avlutte vises nyKomonentView
    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    //Legg til en ny komponent dersom alt i denne klassen er oppfylt
    @FXML
    public void leggTilAction() throws Exception{
        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblFormatFeil.setText("");
        lblStorrelseFeil.setText("");
        lblLesehastighetFeil.setText("");
        lblSkrivehastighetFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();
        String storrelse  = txtLagringskapasitet.getText();
        String lesehastighet = txtLesehastighet.getText();
        String skrivehastighet = txtSkrivehastighet.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        boolean check6 = true;
        boolean check7 = true;

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

        //Valderer Størrelse
        if(Check.heltallCheck(storrelse) == false){
            lblStorrelseFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Lesehastighet
        if(Check.heltallCheck(lesehastighet) == false){
            lblLesehastighetFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        //Validerer Skrivehastighet
        if(Check.heltallCheck(skrivehastighet) == false) {
            lblSkrivehastighetFeil.setText("Må inneholde kun tall");
            check6 = false;
        }

        //Validerer Format
        if(choFormat.getValue() == null){
            lblFormatFeil.setText("Må fylles ut");
            check7 = false;
        }

        //Kun dersom check'ene er oppfylt lages det en ny lagringsenhet
        if (check1 && check2 && check3 && check4 && check5 && check6 && check7){
            Lagringsenhet nyLagringsenhet = new Lagringsenhet(varemerke,
                    modell, Double.parseDouble(pris),
                    choFormat.getValue().toString(),
                    Integer.parseInt(storrelse),
                    lesehastighet, skrivehastighet);
            KomponentData.leggTilKomponent(nyLagringsenhet);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            Advarsel.informasjonsAlert("Lagringsenhet registrert", varemerke +
                            " er registrert", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }

    public void initialize() {
        choFormat.setValue("SSD 2.5");
    }
}
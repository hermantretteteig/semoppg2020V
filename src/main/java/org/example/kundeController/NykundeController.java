package org.example.kundeController;

import data.KundeData;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import logikk.Advarsel;
import models.brukere.Kunde;
import validering.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NykundeController {

    @FXML
    private Label lblGjentaPassordFeil, lblFornavnFeil, lblEtternavnFeil,
            lblPassordFeil, lblBrukernavnFeil, lblEpostFeil;

    @FXML
    private TextField txtFornavn, txtEtternavn, txtBrukernavn,
            txtEpost, txtGjentaPassord, txtPassord;

    @FXML private Button avslutt;

    //Dersom brukeren vil avlutte, lukk vinduet
    @FXML
    public void avsluttAction(ActionEvent event){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    //Legg til en ny komponent dersom alt i denne metoden er oppfylt
    @FXML
    public void registrerAction(ActionEvent event) {

        lblFornavnFeil.setText("");
        lblEtternavnFeil.setText("");
        lblBrukernavnFeil.setText("");
        lblPassordFeil.setText("");
        lblGjentaPassordFeil.setText("");
        lblEpostFeil.setText("");

        String fornavn = txtFornavn.getText();
        String etternavn = txtEtternavn.getText();
        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassord.getText();
        String gjentaPassord = txtGjentaPassord.getText();
        String epost = txtEpost.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        boolean check6 = true;


        //Validerer fornavn
        if (Check.bokstavercheck(fornavn) == false) {
            lblFornavnFeil.setText("Fornavn er ugyldig");
            check1 = false;
        }

        //Validerer etternavn
        if (Check.bokstavercheck(etternavn) == false) {
            lblEtternavnFeil.setText("Fornavn er ugyldig");
            check2 = false;
        }

        //Validerer brukernavn
        if (Check.lengdeCheck(brukernavn) == false) {
            lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
            check3 = false;
        }

        //Validerer epost
        if (Check.epostchecker(epost) == false) {
            lblEpostFeil.setText("Eposen er ugyldig.");
            check6 = false;
        }

        //Validerer passord
        if (Check.passordchecker(passord) == false) {
            lblPassordFeil.setText("Må være små og store bokstaver, minst 8 tegn og tall.");
            check4 = false;
        }

        //Validerer gjentatt passord
        if (Check.passordValCheck(gjentaPassord, passord) == false) {
            lblGjentaPassordFeil.setText("Passordene er ulike.");
            check5 = false;
        }

        //Kun dersom check'ene er oppfylt legg til ny bruker
        Kunde nyKunde = new Kunde(fornavn, etternavn, brukernavn, passord, epost);
        if (check1 && check2 && check3 && check4 && check5 && check6) {
            KundeData.leggTilKunde(nyKunde);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            //Avslutter viewet
            stage.close();
            //Viser informasjon til bruker om at kunden er registrert
            Advarsel.informasjonsAlert("Kunde registrert", brukernavn +
                    " er registrert.", "");
        }
    }
}
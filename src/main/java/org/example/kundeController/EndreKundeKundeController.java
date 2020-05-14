package org.example.kundeController;

import data.InnloggetBrukerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logikk.Advarsel;
import org.example.App;
import validering.*;

import java.io.IOException;

public class EndreKundeKundeController {

    @FXML
    private Label lblGjentaPassordFeil, lblFornavnFeil, lblEtternavnFeil,
            lblPassordFeil, lblBrukernavnFeil, lblEpostFeil, lblFeil;

    @FXML
    private TextField txtFornavn, txtEtternavn, txtBrukernavn, txtEpost,
        txtGjentaPassord, txtPassord;

    //Dersom brukeren vil avlutte gå tilbake til dashboadKunde
    @FXML
    private void avsluttAction(ActionEvent event) throws IOException {
        App.setRoot("kundeView/dashboardKunde");
    }

    @FXML
    private void registrerAction(ActionEvent event) throws IOException {

        lblFornavnFeil.setText("");
        lblEtternavnFeil.setText("");
        lblBrukernavnFeil.setText("");
        lblPassordFeil.setText("");
        lblGjentaPassordFeil.setText("");
        lblEpostFeil.setText("");
        lblFeil.setText("");

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
            lblEtternavnFeil.setText("Etternavn er ugyldig");
            check2 = false;
        }

        //Validerer brukernavn
        if (Check.lengdeCheck(brukernavn) == false) {
            lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
            check3 = false;
        }

        //Validerer epost
        if (Check.epostchecker(epost) == false) {
            lblEpostFeil.setText("Eposten er ugyldig.");
            check6 = false;
        }

        //Validerer passord
        if (Check.passordchecker(passord) == false && !(txtPassord.getText().isBlank())) {
            lblPassordFeil.setText("Må være små og store bokstaver, minst 8 tegn og tall.");
            check4 = false;
        }

        //Validerer gjentatt passord
        if (Check.passordValCheck(gjentaPassord, passord) == false && !(txtGjentaPassord.getText().isBlank())) {
            lblGjentaPassordFeil.setText("Passordene er ulike.");
            check5 = false;
        }

        //Kontrollerer at alle felt er gyldig før eventuelt verdiene endres
        if (check1 && check2 && check3 && check4 && check5 && check6) {
            InnloggetBrukerData.getInnloggetKunde().setFornavn(txtFornavn.getText());
            InnloggetBrukerData.getInnloggetKunde().setEtternavn(txtEtternavn.getText());
            InnloggetBrukerData.getInnloggetKunde().setBrukernavn(txtBrukernavn.getText());
            InnloggetBrukerData.getInnloggetKunde().setEpost(txtEpost.getText());

            if(!txtPassord.getText().isEmpty()) {
                InnloggetBrukerData.getInnloggetKunde().setPassord(txtPassord.getText());
            }

            Advarsel.informasjonsAlert("Endringer lagret", "Dine endringer er lagret", "");
            App.setRoot("kundeView/dashboardKunde");

        }
        //Hvis det brukeren har skrevet inn ugyldig verdi gis det informasjon om dette.
        else {
            lblFeil.setText("Ett eller flere tekstfelt inneholdt ugyldig verdi. Prøv på nytt!");
        }
    }

    //Henter inn informasjonen til brukeren.
    @FXML
    public void initialize(){
        txtFornavn.setText(InnloggetBrukerData.getInnloggetKunde().getFornavn());
        txtEtternavn.setText(InnloggetBrukerData.getInnloggetKunde().getEtternavn());
        txtBrukernavn.setText(InnloggetBrukerData.getInnloggetKunde().getBrukernavn());
        txtEpost.setText(InnloggetBrukerData.getInnloggetKunde().getEpost());
    }
}
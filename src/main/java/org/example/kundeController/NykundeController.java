package org.example.kundeController;

import data.KundeData;
import models.brukere.Kunde;
import validering.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NykundeController {
    public Label lblGjentaPassordFeil;
    public Label lblFornavnFeil;
    public Label lblEtternavnFeil;
    public Label lblPassordFeil;
    public Label lblBrukernavnFeil;
    public Label lblEpostFeil;

    public TextField txtFornavn;
    public TextField txtEtternavn;
    public TextField txtBrukernavn;
    public TextField txtEpost;
    public PasswordField txtGjentaPassord;
    public PasswordField txtPassord;


    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;

    @FXML
    private void avsluttAction(){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrerAction() {

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
        if (BokstaverCheck.bokstavercheck(fornavn) == false) {
            lblFornavnFeil.setText("Fornavn er ugyldig");
            check1 = false;
        }

        //Validerer etternavn
        if (BokstaverCheck.bokstavercheck(etternavn) == false) {
            lblEtternavnFeil.setText("Fornavn er ugyldig");
            check2 = false;
        }

        //Validerer brukernavn
        if (LengeCheck.lengdeCheck(brukernavn) == false) {
            lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
            check3 = false;
        }

        //Validerer epost
        if (EpostCheck.epostchecker(epost) == false) {
            lblEpostFeil.setText("Eposen er ugyldig.");
            check6 = false;
        }

        //Validerer passord
        if (PassordCheck.passordchecker(passord) == false) {
            lblPassordFeil.setText("Må være små og store bokstaver, minst 8 tegn og tall.");
            check4 = false;
        }

        //Validerer gjentatt passord
        if (PassordValCheck.passordValCheck(gjentaPassord, passord) == false) {
            lblGjentaPassordFeil.setText("Passordene er ulike.");
            check5 = false;
        }

        Kunde nyKunde = new Kunde(fornavn, etternavn, brukernavn, passord, epost);
        if (check1 && check2 && check3 && check4 && check5 && check6) {
            KundeData.leggTilKunde(nyKunde);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
        }

        //App.setRoot("Adminview/nyAdminView/nyAdmin");

        //Stage stage = (Stage) registrer.getScene().getWindow();
        //stage.close();
    }
}
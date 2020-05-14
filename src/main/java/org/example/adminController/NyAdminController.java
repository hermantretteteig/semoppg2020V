package org.example.adminController;

import data.AdminData;
import logikk.Advarsel;
import models.brukere.Admin;
import validering.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NyAdminController {

    //Oppretter tekstfelt ved feil-input
    public Label lblGjentaPassordFeil;
    public Label lblFornavnFeil;
    public Label lblEtternavnFeil;
    public Label lblPassordFeil;
    public Label lblBrukernavnFeil;

    //Opprett inputfelt
    public TextField txtFornavn;
    public TextField txtEtternavn;
    public TextField txtBrukernavn;
    public PasswordField txtGjentaPassord;
    public PasswordField txtPassord;

    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;

    //Dersom brukeren vil avlutte, lukk vinduet
    @FXML
    private void avsluttAction(){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    //Legg til en ny admin dersom alt i denne metoden er oppfylt
    @FXML
    private void registrerAction() {

        lblFornavnFeil.setText("");
        lblEtternavnFeil.setText("");
        lblBrukernavnFeil.setText("");
        lblPassordFeil.setText("");
        lblGjentaPassordFeil.setText("");

        String fornavn = txtFornavn.getText();
        String etternavn = txtEtternavn.getText();
        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassord.getText();
        String gjentaPassord = txtGjentaPassord.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        boolean check6 = true;

        //Validerer fornavn
        if(Check.bokstavercheck(fornavn) == false){
            lblFornavnFeil.setText("Fornavn er ugyldig");
            check1 = false;
        }

        //Validerer etternavn
        if(Check.bokstavercheck(etternavn) == false){
            lblEtternavnFeil.setText("Etternavn er ugyldig");
            check1 = false;
        }

        //Validerer brukernavn
        if(Check.lengdeCheck(brukernavn) == false){
            lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
            check1 = false;
        }

        //Validerer passord
        if(Check.passordchecker(passord) == false){
            lblPassordFeil.setText("Må være små og store bokstaver, minst 8 tegn og tall.");
            check1 = false;
        }

        //Validerer gjentatt passord
        if(Check.passordValCheck(gjentaPassord, passord) == false){
            lblGjentaPassordFeil.setText("Passordene er ulike.");
            check1 = false;
        }

        //Kun dersom check'ene er oppfylt legg til admin
        if (check1 && check2 && check3 && check4 && check5 && check6){
            Admin nyAdmin = new Admin(fornavn, etternavn, brukernavn, passord);
            AdminData.leggTilAdmin(nyAdmin);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
            Advarsel.informasjonsAlert("Administrator registrert", brukernavn +
                    " er registrert.", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }
}
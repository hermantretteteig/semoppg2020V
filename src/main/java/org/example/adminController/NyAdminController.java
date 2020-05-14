package org.example.adminController;

import data.AdminData;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import logikk.Advarsel;
import models.brukere.Admin;
import validering.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NyAdminController {

    @FXML
    public Label lblGjentaPassordFeil, lblFornavnFeil, lblEtternavnFeil, lblPassordFeil, lblBrukernavnFeil;

    @FXML
    public TextField txtFornavn, txtEtternavn, txtBrukernavn, txtGjentaPassord, txtPassord;

    @FXML private Button registrer, avslutt;

    //Dersom brukeren vil avlutte, lukk vinduet
    @FXML
    private void avsluttAction(ActionEvent event){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    //Legg til en ny admin
    @FXML
    private void registrerAction(ActionEvent event) {

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
            //Legger til den nye adminen i listen
            AdminData.leggTilAdmin(nyAdmin);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
            Advarsel.informasjonsAlert("Administrator registrert", brukernavn +
                    " er registrert.", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }
}
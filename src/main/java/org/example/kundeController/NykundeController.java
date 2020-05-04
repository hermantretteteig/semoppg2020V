package org.example.kundeController;

import data.KundeData;
import models.brukere.Bruker;
import models.brukere.Kunde;
import org.example.App;
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


        /*

        Jeg prøde å korte ned noen feilmeldinger Salem, ettersom de ble veldig lange for GUI-et.
        Se også TO DO-lenger ned

        Herman
        02.05.2020 : 14:21

         */

        String fornavn = txtFornavn.getText();
        String etternavn = txtEtternavn.getText();
        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassord.getText();
        String gjentaPassord = txtGjentaPassord.getText();
        String epost = txtEpost.getText();


        //Validerer fornavn
        if (BokstaverCheck.bokstavercheck(fornavn) == false) {
            lblFornavnFeil.setText("Fornavn er ugyldig");
        }

        //Validerer etternavn
        if (BokstaverCheck.bokstavercheck(etternavn) == false) {
            lblEtternavnFeil.setText("Fornavn er ugyldig");
        }

        //Validerer brukernavn
        if (LengeCheck.lengdeCheck(brukernavn) == false) {
            lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
        }

        //Validerer passord
        if (PassordCheck.passordchecker(passord) == false) {
            lblPassordFeil.setText("Må være små og store bokstaver, minst 8 tegn og tall.");
        }

        //Validerer gjentatt passord
        if (PassordValCheck.passordValCheck(gjentaPassord, passord) == false) {
            lblGjentaPassordFeil.setText("Passordene er ulike.");
        }

        //Validerer epost
        if (EpostCheck.epostchecker(epost) == false) {
            lblEpostFeil.setText("Eposen er ugyldig.");
        }


        //TODO KODEN UNDER MÅ BARE KJØRES HVIS INPUT ER GYLDIG, FIKSER DU DET SALEM?
        Kunde nyKunde = new Kunde(fornavn, etternavn, brukernavn, passord, epost);
        KundeData.leggTilKunde(nyKunde);
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();

    }

    //Stage stage = (Stage) registrer.getScene().getWindow();
    //stage.close();
}

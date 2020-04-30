package org.example.kundeController;

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
    private void registrerAction(){

            lblFornavnFeil.setText("");
            lblEtternavnFeil.setText("");
            lblBrukernavnFeil.setText("");
            lblPassordFeil.setText("");
            lblGjentaPassordFeil.setText("");
            lblEpostFeil.setText("");


            //Validerer fornavn
            if(BokstaverCheck.bokstavercheck(txtFornavn.getText()) == false){
                lblFornavnFeil.setText("Fornavn må kunne inneholde bokstaver");
            }

            //Validerer etternavn
            if(BokstaverCheck.bokstavercheck(txtEtternavn.getText()) == false){
                lblEtternavnFeil.setText("Etternavn må kun inneholde bokstaver");
            }

            //Validerer brukernavn
            if(LengeCheck.lengdeCheck(txtBrukernavn.getText()) == false){
                lblBrukernavnFeil.setText("Må inneholde minst to tegn.");
            }

            //Validerer passord
            if(PassordCheck.passordchecker(txtPassord.getText()) == false){
                lblPassordFeil.setText("Passord må inneholde:" + "Små og store bokstaver, minst 8 tegn og tall ");
            }

            //Validerer gjentatt passord
            if(PassordValCheck.passordValCheck(txtGjentaPassord.getText(), txtPassord.getText()) == false){
                lblGjentaPassordFeil.setText("Passordene er ulike.");
            }

            //Validerer epost
            if(EpostCheck.epostchecker(txtEpost.getText())==false){
                lblEpostFeil.setText("Eposen er ugyldig.");
            }





        //Stage stage = (Stage) registrer.getScene().getWindow();
        //stage.close();
    }
}

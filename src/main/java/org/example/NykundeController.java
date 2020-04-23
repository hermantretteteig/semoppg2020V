package org.example;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NykundeController {
    public Label lblGjentaPassordFeil;
    public Label lblFornavnFeil;
    public Label lblEtternavnFeil;
    public Label lblPassordFeil;
    public Label lblBrukernavnFeil;

    public TextField txtFornavn;
    public TextField txtEtternavn;
    public TextField txtBrukernavn;
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

            if(txtFornavn.getText().length()<2){
                lblFornavnFeil.setText("Fornavn må være minst to tegn.");
            }
            if(txtEtternavn.getText().length()<2){
                lblEtternavnFeil.setText("Etternavn må være minst to tegn.");
            }
            if(txtBrukernavn.getText().length()<2){
                lblBrukernavnFeil.setText("Må være minst to tegn.");
            }
            if(txtPassord.getText().length()<8){
                lblPassordFeil.setText("Passord må være minst 8 tegn.");
            }
            if(!(txtGjentaPassord.getText().equals(txtPassord.getText()))){
                lblGjentaPassordFeil.setText("Passordene er ulike.");
            }





        //Stage stage = (Stage) registrer.getScene().getWindow();
        //stage.close();
    }
}

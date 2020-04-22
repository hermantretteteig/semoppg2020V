package org.example;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class NybrukerController {
    public Label lblGjentaPassordFeil;
    public Label lblFornavnFeil;
    public Label lblEtternavnFeil;
    public Label lblPassordFeil;
    public Label lblBrukernavnFeil;

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

            lblPassordFeil.setText("");
            lblGjentaPassordFeil.setText("");

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

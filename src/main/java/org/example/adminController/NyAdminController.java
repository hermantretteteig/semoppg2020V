package org.example.adminController;

import data.AdminData;
import models.brukere.Admin;
import models.brukere.Bruker;
import org.example.App;
import validering.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NyAdminController {

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
    private void registrerAction() {

        lblFornavnFeil.setText("");
        lblEtternavnFeil.setText("");
        lblBrukernavnFeil.setText("");
        lblPassordFeil.setText("");
        lblGjentaPassordFeil.setText("");

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

        //Admin nyAdmin = new Admin(txtFornavn.getText(), txtEtternavn.getText(), txtBrukernavn.getText(), txtPassord.getText());
        //AdminData.leggTilBruker(nyAdmin);

        //App.setRoot("Adminview/nyAdminView/nyAdmin");


        //Stage stage = (Stage) registrer.getScene().getWindow();
        //stage.close();
    }
}


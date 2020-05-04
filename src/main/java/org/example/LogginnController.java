package org.example;

import java.io.IOException;

import data.InnloggetBrukerData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogginnController  {

    @FXML
    public Label lblBrukerFeil;
    public Label lblAdminFeil;
    public TextField txtKundeBrukernavn;
    public PasswordField txtKundePassord;
    public TextField txtAdminBrukernavn;
    public PasswordField txtAdminPassord;

    @FXML
    private void nyBruker() throws IOException {
        //Åpner vindu for å registrere Kunde
        App.nyttLiteVindu("kundeView/nykunde", "Ny kunde", 365, 410);
    }

    @FXML
    private void logginn() throws IOException {

         if(InnloggetBrukerData.loggInnKunde(txtKundeBrukernavn.getText(), txtKundePassord.getText())==false){
             lblBrukerFeil.setText("Ugyldig brukernavn/passord");
         }
         else{
             App.setRoot("kundeView/dashboardKunde");
         }
    }

    @FXML
    private void adminLoggInnAction() throws IOException {
        if(InnloggetBrukerData.loggInnAdmin(txtAdminBrukernavn.getText(), txtAdminPassord.getText())==false){
            lblAdminFeil.setText("Ugyldig brukernavn/passord");
        }
        else{
            App.setRoot("adminView/dashboardAdmin");
        }
    }






}

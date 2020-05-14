package org.example;

import java.io.IOException;

import data.InnloggetBrukerData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogginnController  {


    @FXML
    private Label lblBrukerFeil, lblAdminFeil;

    @FXML
    private TextField txtKundeBrukernavn, txtKundePassord, txtAdminBrukernavn, txtAdminPassord;

    @FXML
    private void nyBruker() throws IOException {
        //Åpner vindu for å registrere kunde
        App.nyttLiteVindu("kundeView/nykunde", "Ny kunde", 365, 410);
    }

    @FXML
    private void logginn() throws IOException {
        //Sjekker om kombinasjonen av brukernavn og passord eksiterer i listen over kunder
         if(InnloggetBrukerData.loggInnKunde(txtKundeBrukernavn.getText(), txtKundePassord.getText())==true){
             App.setRoot("kundeView/dashboardKunde");
         }
         //Hvis ikke de eksiterer gis det informasjon om feil brukernavn/passord
         else{
             lblBrukerFeil.setText("Ugyldig brukernavn/passord");

             //TODO linja under må fjernes før levering
             App.setRoot("kundeView/dashboardKunde");

         }
    }

    @FXML
    private void adminLoggInnAction() throws IOException {
        //Sjekker om kombinasjonen av brukernavn og passord eksiterer i listen over administratorer
        if(InnloggetBrukerData.loggInnAdmin(txtAdminBrukernavn.getText(), txtAdminPassord.getText())==true){
            App.setRoot("adminView/dashboardAdmin");

        }
        //Hvis ikke de eksiterer gis det informasjon om feil brukernavn/passord
        else{
            lblAdminFeil.setText("Ugyldig brukernavn/passord");

            //TODO linja under må fjernes før levering
            App.setRoot("adminView/dashboardAdmin");
        }
    }
}
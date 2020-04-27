package org.example;

import java.io.IOException;

import data.KomponentData;
import javafx.fxml.FXML;

public class LogginnController  {

    @FXML
    private void nyBruker() throws IOException {
        //Åpner vindu for å registrere Kunde
        App.nyttLiteVindu("kundeView/nykunde", "Ny kunde", 365, 410);
    }

    @FXML
    private void logginn() throws IOException {
         /*

        TRY/CATCH HER SOM SØRGER FOR AT BRUKEREN BARE FÅR LOGGET INN HVIS PASSORD OG BRUKERNAVN ER GYLDIG

         */

        App.setRoot("kundeView/dashboardKunde");
    }

    @FXML
    private void adminLoggInnAction() throws IOException {

         /*

        TRY/CATCH HER SOM SØRGER FOR AT ADMIN BARE FÅR LOGGET INN HVIS PASSORD OG BRUKERNAVN ER GYLDIG

         */

        App.setRoot("adminView/dashboardAdmin");
    }






}

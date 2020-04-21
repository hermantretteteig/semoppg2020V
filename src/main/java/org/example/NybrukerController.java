package org.example;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class NybrukerController {

    @FXML private javafx.scene.control.Button avslutt;
    @FXML
    private void avsluttAction(){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    @FXML private javafx.scene.control.Button registrer;
    @FXML
    private void registrerAction(){
        Stage stage = (Stage) registrer.getScene().getWindow();
        // Kode for å legge til data i et array
        stage.close();
    }
}

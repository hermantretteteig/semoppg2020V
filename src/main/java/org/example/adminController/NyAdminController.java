package org.example.adminController;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.example.App;

public class NyAdminController {


    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;

    @FXML
    private void avsluttAction(){
        Stage stage = (Stage) avslutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrerAction() {
        /*

        VALIDERING FØR DEN LEGGER TIL I LISTE

         */
        Stage stage = (Stage) registrer.getScene().getWindow();
        stage.close();
    }
    }


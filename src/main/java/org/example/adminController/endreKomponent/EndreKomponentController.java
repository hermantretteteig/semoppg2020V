package org.example.adminController.endreKomponent;

import javafx.fxml.FXML;
import org.example.App;

public class EndreKomponentController {

    @FXML
    public void tilbakeAction() throws Exception{
        App.setRoot("adminView/dashboardAdmin");
    }
}

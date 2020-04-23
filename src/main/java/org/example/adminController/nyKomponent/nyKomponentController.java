package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.App;

public class nyKomponentController {


    @FXML
    public void nySkjermkortAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nySkjermkort");
    }

    @FXML
    public void tilDashboardAction() throws Exception{
        App.setRoot("adminView/dashboardAdmin");
    }



}

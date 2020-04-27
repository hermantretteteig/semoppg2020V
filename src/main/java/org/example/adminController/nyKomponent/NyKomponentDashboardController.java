package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.App;

public class NyKomponentDashboardController {


    @FXML
    public void tilDashboardAction() throws Exception {
        App.setRoot("adminView/dashboardAdmin");
    }

    @FXML
    public void nySkjermkortAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nySkjermkort");
    }

    @FXML
    public void nyLagringsenhetAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nyLagringsenhet");
    }

    @FXML
    public void nyMusAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nyMus");
    }

    @FXML
    public void nyProsessorAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nyProsessor");
    }

    @FXML
    public void nySkjermAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nySkjerm");
    }

    @FXML
    public void nyTastaturAction() throws Exception {
        App.setRoot("adminView/nyKomponentView/nyTastatur");
    }


}

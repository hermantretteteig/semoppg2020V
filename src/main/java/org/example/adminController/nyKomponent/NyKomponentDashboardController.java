package org.example.adminController.nyKomponent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;

public class NyKomponentDashboardController {


    @FXML
    public void tilDashboardAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/dashboardAdmin");
    }

    @FXML
    public void nySkjermkortAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nySkjermkort");
    }

    @FXML
    public void nyLagringsenhetAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nyLagringsenhet");
    }

    @FXML
    public void nyMusAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nyMus");
    }

    @FXML
    public void nyProsessorAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nyProsessor");
    }

    @FXML
    public void nySkjermAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nySkjerm");
    }

    @FXML
    public void nyTastaturAction(ActionEvent event) throws Exception {
        App.setRoot("adminView/nyKomponentView/nyTastatur");
    }
}
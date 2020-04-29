package org.example.kundeController;
import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableView;
import models.komponent.Komponent;
import org.example.App;

import java.io.IOException;

public class DashboardKundeController {



    public void lagreAction(){

    }

    public void nyttKjopAction() throws IOException {
        App.setRoot("kundeView/nyttKjop");
    }

    public void tidligereKjopAction(){

    }

    @FXML
    public void loggUtAction() throws Exception{
        //kode som avslutter session
        App.setRoot("loggInn");

    }

}

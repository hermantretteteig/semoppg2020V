package org.example.kundeController;
import javafx.fxml.FXML;
import org.example.App;

public class DashboardKundeController {

    public void lagreAction(){

    }

    public void nyttKjopAction(){

    }

    public void tidligereKjopAction(){

    }

    @FXML
    public void loggUtAction() throws Exception{
        //kode som avslutter session
        App.setRoot("loggInn");

    }
}

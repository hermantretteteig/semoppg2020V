package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import logikk.NyKomponentAlert;
import models.komponent.Mus;
import models.komponent.Skjermkort;
import org.example.App;

import java.util.concurrent.TimeUnit;

public class NyMusController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblTrodlosFeil;
    public Label lblFargeFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choTrodlos;
    public ColorPicker colFarge;



    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("test");
        lblModellFeil.setText("test");
        lblPrisFeil.setText("test");
        lblTrodlosFeil.setText("test");
        lblFargeFeil.setText("test");


        /*

        METODER SOM VALIDERER ALLE TEKTFELT, OG GIR FEILMELDINGER TIL FELT MED FEIL

         */


        //HVIS FELTENE ER GYLDIGE GJØR FØLGENDE UNDER
                boolean trodlos = false;
                if(choTrodlos.getValue().equals("Ja")){
                    trodlos = true;
                }

                Mus nyMus = new Mus("2300", txtVaremerke.getText(), txtModell.getText(), Integer.parseInt(txtPris.getText()), trodlos, colFarge.getValue().toString());
                KomponentData.leggTilKomponent(nyMus);

                NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());

                //Rooter tilslutt til oversiktview
                App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

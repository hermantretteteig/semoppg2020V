package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.komponent.Tastatur;
import org.example.App;
import validering.*;

public class NyTastaturController {

    public Label lblVarenummerfeil;
    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblNumpadFeil;
    public Label lblTrodlos;

    public TextField txtVarenummer;
    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choNumpad;
    public ChoiceBox choTrodlos;



    @FXML
    public void leggTilAction() {

        lblVarenummerfeil.setText("");
        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblNumpadFeil.setText("");
        lblTrodlos.setText("");

        //Validerer Varenummer


        //Validerer Varemerke
        if(BokstaverCheck.bokstavercheck(txtVaremerke.getText()) == false){
            lblVaremerkeFeil.setText("Må kunne inneholde bokstaver");
        }

        //Validerer Modell
        if(LengeCheck.lengdeCheck(txtModell.getText()) == false){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
        }

        //Validerer Pris
        if(TallCheck.tallcheck(txtPris.getText()) == false){
            lblPrisFeil.setText("Må inneholde kun tall");
        }
        double pris = Double.parseDouble(txtPris.getText());

        //Validerer Numpad
        if(choNumpad.getValue() == null) {
            lblNumpadFeil.setText("Må fylles ut");
        }

        //Validerer Trådløs
        if(choTrodlos.getValue() == null) {
            lblNumpadFeil.setText("Må fylles ut");
        }

        //Tastatur nyTastatur = new Tastatur();
        //KomponentData.leggTilKomponent(nyTastatur);

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

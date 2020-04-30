package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.App;
import validering.*;

public class NyTastaturController {

    public Label lblVarenummerfeil;
    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;

    public TextField txtVarenummer;
    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;

    //Må lage to avkrysningsbokser for numpad og trådløs





    @FXML
    public void leggTilAction() {

        lblVarenummerfeil.setText("");
        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");

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

package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;


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

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblTrodlosFeil.setText("");
        lblFargeFeil.setText("");

        //Validerer varenummer?

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


        if(choTrodlos.getValue() == null) {
            lblTrodlosFeil.setText("Må fylles ut");
        }

        //Mus nyMus = new Mus("2300", txtVaremerke.getText(), txtModell.getText(), Integer.parseInt(txtPris.getText()), trodlos, colFarge.getValue().toString());
        //KomponentData.leggTilKomponent(nyMus);

        //NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

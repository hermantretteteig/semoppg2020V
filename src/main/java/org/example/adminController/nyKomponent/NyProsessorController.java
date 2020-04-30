package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;

public class NyProsessorController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblKjernerFeil;
    public Label lblKlokkehastighetFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtKjerner;
    public TextField txtKlokkehastighet;


    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblKjernerFeil.setText("");
        lblKlokkehastighetFeil.setText("");

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

        //Validerer Kjerner
        if(TallCheck.tallcheck(txtKjerner.getText()) == false){
            lblKjernerFeil.setText("Må inneholde kun tall");
        }

        //Validerer Klokkehastighet
        if(TallCheck.tallcheck(txtKlokkehastighet.getText()) == false){
            lblKlokkehastighetFeil.setText("Må inneholde kun tall");
        }

        double pris = Double.parseDouble(txtPris.getText());


        //Prosessor nyProsessor = new Prosessor();
        //KomponentData.leggTilKomponent(nyProsessor);

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

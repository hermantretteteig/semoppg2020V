package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logikk.NyKomponentAlert;
import models.komponent.Lagringsenhet;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;

public class NyLagringsenhetController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblFormatFeil;
    public Label lblStorrelseFeil;
    public Label lblLagringsenhetFeil;
    public Label lblLesehastighetFeil;
    public Label lblSkrivehastighetFeil;


    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choFormat;
    public TextField txtStorrelse;
    public TextField txtLesehastighet;
    public TextField txtSkrivehastighet;

    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblFormatFeil.setText("");
        lblStorrelseFeil.setText("");
        lblLesehastighetFeil.setText("");
        lblSkrivehastighetFeil.setText("");

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

        //Valderer Størrelse
        if(TallCheck.tallcheck(txtStorrelse.getText()) == false){
            lblStorrelseFeil.setText("Må inneholde kun tall");
        }

        //Validerer Lesehastighet
        if(TallCheck.tallcheck(txtLesehastighet.getText()) == false){
            lblLesehastighetFeil.setText("Må inneholde kun tall");
        }

        //Validerer Skrivehastighet
        if(TallCheck.tallcheck(txtSkrivehastighet.getText()) == false) {
            lblSkrivehastighetFeil.setText("Må inneholde kun tall");
        }


        //Validerer Format
        if(choFormat.getValue() == null){
            lblFormatFeil.setText("Må fylles ut");
        }

        //Lagringsenhet nyLagringsenhet = new Lagringsenhet(txtVaremerke.getText(), txtModell.getText(), txtPris.getText(), txtStorrelse.getText(), txtLesehastighet.getText(), txtSkrivehastighet.getText());
        //KomponentData.leggTilKomponent(nyLagringsenhet);
        //NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());

        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

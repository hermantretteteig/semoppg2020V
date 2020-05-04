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

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());
        //Lage en for format også?
        String storrelse  = txtStorrelse.getText();
        String lesehastighet = txtLesehastighet.getText();
        String skrivehastighet = txtSkrivehastighet.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        boolean check6 = true;
        boolean check7 = true;


        //Validerer Varenummer


        //Validerer Varemerke
        if(BokstaverCheck.bokstavercheck(varemerke) == false){
            lblVaremerkeFeil.setText("Må kunne inneholde bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if(LengeCheck.lengdeCheck(modell) == false){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if(TallCheck.tallcheck(txtPris.getText()) == false){
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Valderer Størrelse
        if(TallCheck.tallcheck(storrelse) == false){
            lblStorrelseFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Lesehastighet
        if(TallCheck.tallcheck(lesehastighet) == false){
            lblLesehastighetFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        //Validerer Skrivehastighet
        if(TallCheck.tallcheck(skrivehastighet) == false) {
            lblSkrivehastighetFeil.setText("Må inneholde kun tall");
            check6 = false;
        }

        //Validerer Format
        if(choFormat.getValue() == null){
            lblFormatFeil.setText("Må fylles ut");
            check7 = false;
        }

        //Lagringsenhet nyLagringsenhet = new Lagringsenhet(txtVaremerke.getText(), txtModell.getText(), txtPris.getText(), txtStorrelse.getText(), txtLesehastighet.getText(), txtSkrivehastighet.getText());
        if(check1 == true && check2 == true && check3 == true && check4 == true && check5 == true) {
            //KomponentData.leggTilKomponent(nyLagringsenhet);
            //NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());
        }
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Tore.Test;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;

public class NyLagringsenhetController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblFormatFeil;
    public Label lblStorrelse;
    public Label lblLagringsenhetFeil;
    public Label lblLesehastighetFeil;
    public Label lblSkrivehastighetFeil;


    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choFormat;
    public TextField txtStorrelse;
    public TextField txtLagringskapasitet;
    public TextField txtSkrivehastighet;
    public TextField txtLesehastighet;


    @FXML
    public void leggTilAction() throws Exception{
        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblFormatFeil.setText("");
        lblStorrelse.setText("");
        lblLagringsenhetFeil.setText("");
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

        //Valider Lagringsformat?

        //Valderer Størrelse
        if(TallCheck.tallcheck(txtStorrelse.getText()) == false){
            lblStorrelse.setText("Må inneholde kun tall");
        }

        //Validerer Lesehastighet
        if(TallCheck.tallcheck(txtLesehastighet.getText()) == false){
            lblLesehastighetFeil.setText("Må inneholde kun tall");
        }

        //Validerer Skrivehastighet
        if(TallCheck.tallcheck(txtSkrivehastighet.getText()) == false) {
            lblSkrivehastighetFeil.setText("Må inneholde kun tall");
        }

        double pris = Double.parseDouble(txtPris.getText());


        //Husk å test dennne!!!
        //HVIS FELTENE ER GYLDIGE GJØR FØLGENDE UNDER
        boolean trodlos = true;
        if(choFormat.getValue().equals("")){
            trodlos = false;
            lblFormatFeil.setText("Må fylles ut");
        }

        //Lagringsenhet nyLagringsenhet = new Lagringsenhet();
        //KomponentData.leggTilKomponent(nyLagringsenhet);

        //Rooter tilslutt til oversiktview

        //Hvis felter ok:
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

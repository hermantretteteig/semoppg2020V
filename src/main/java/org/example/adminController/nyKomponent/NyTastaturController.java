package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logikk.Advarsel;
import models.komponent.Tastatur;
import org.example.App;
import validering.*;
import java.io.IOException;

public class NyTastaturController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblNumpadFeil;
    public Label lblTrodlosFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choNumpad;
    public ChoiceBox choTrodlos;

    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws IOException {
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws IOException {

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");


        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        String pris = txtPris.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        //Validerer Varenummer


        //Validerer Varemerke
        if(Check.lengdeCheck(varemerke) == false){
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if(Check.lengdeCheck(modell) == false){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if(Check.desimaltallCheck(pris) == false){
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Validerer Numpad
        if(choNumpad.getValue().equals(null)) {
            lblNumpadFeil.setText("Må fylles ut");
            check4 = false;
        }
        boolean numpad = false;
        if(choNumpad.getValue().equals("Ja")){
            numpad = true;
        }


        //Validerer Trådløs
        if(choTrodlos.getValue().equals(null)) {
            lblTrodlosFeil.setText("Må fylles ut");
            check5 = false;
        }
        boolean trodlos = false;
        if(choTrodlos.getValue().equals("Ja")){
            trodlos = true;
        }



        if(check1 && check2 && check3 && check4 && check5) {
            Tastatur nyTastatur = new Tastatur(varemerke,
                    modell, Double.parseDouble(pris), trodlos, numpad);
            KomponentData.leggTilKomponent(nyTastatur);
            App.setRoot("adminView/nyKomponentView/nyKomponent");
            Advarsel.informasjonsAlert("Tastatur registrert", varemerke +
                    " er registrert", "For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        }
    }

    public void initialize() {
        choNumpad.setValue("Nei");
        choTrodlos.setValue("Ja");
    }
}

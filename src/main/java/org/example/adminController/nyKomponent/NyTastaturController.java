package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logikk.NyKomponentAlert;
import models.komponent.Tastatur;
import org.example.App;
import validering.*;

public class NyTastaturController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblNumpadFeil;
    public Label lblTrodlos;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public ChoiceBox choNumpad;
    public ChoiceBox choTrodlos;

    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() {

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblNumpadFeil.setText("");
        lblTrodlos.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        //Validerer Varenummer


        //Validerer Varemerke
        if(LengeCheck.lengdeCheck(varemerke) == false){
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
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

        //Validerer Numpad
        if(choNumpad.getValue() == null) {
            lblNumpadFeil.setText("Må fylles ut");
            check4 = false;
        }

        boolean numpad = false;
        if(choNumpad.getValue().equals("Ja")){
            numpad = true;
        }


        //Validerer Trådløs
        if(choTrodlos.getValue() == null) {
            lblNumpadFeil.setText("Må fylles ut");
            check5 = false;
        }
        boolean trodlos = false;
        if(choTrodlos.getValue().equals("Ja")){
            trodlos = true;
        }

        Tastatur nyTastatur = new Tastatur(varemerke,
           modell, pris, trodlos, numpad);

        if(check1 && check2 && check3 && check4 && check5) {
           KomponentData.leggTilKomponent(nyTastatur);
           NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());
           Stage stage = (Stage) avslutt.getScene().getWindow();
           stage.close();
        }
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

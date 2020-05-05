package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logikk.NyKomponentAlert;
import models.komponent.Mus;
import org.example.App;
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

    @FXML public javafx.scene.control.Button registrer;
    @FXML public javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblTrodlosFeil.setText("");
        lblFargeFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;


        //Validerer varenummer?

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
        //Validerer Trodlos
        if(choTrodlos.getValue() == null) {
            lblTrodlosFeil.setText("Må fylles ut");
            check4 = false;
        }
        boolean trodlos = false;
        if(choTrodlos.getValue().equals("Ja")) {
            trodlos = true;
        }

        Mus nyMus = new Mus(varemerke, modell, pris, trodlos, colFarge.getValue().toString());
        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nyMus);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
            NyKomponentAlert.visBekreftelse(varemerke, modell);
        }

        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

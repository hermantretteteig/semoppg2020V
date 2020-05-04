package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logikk.NyKomponentAlert;
import models.komponent.Prosessor;
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


    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;


    @FXML
    public void leggTilAction(){

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblKjernerFeil.setText("");
        lblKlokkehastighetFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());
        String kjerner = txtKjerner.getText();
        String klokkehastighet = txtKlokkehastighet.getText();

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

        //Validerer Kjerner
        if(TallCheck.tallcheck(kjerner) == false){
            lblKjernerFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Klokkehastighet
        if(TallCheck.tallcheck(klokkehastighet) == false){
            lblKlokkehastighetFeil.setText("Må inneholde kun tall");
            check5 = false;
        }

        Prosessor nyProsessor = new Prosessor(varemerke, modell, pris,
                Integer.parseInt(kjerner),
                Double.parseDouble(klokkehastighet));
        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nyProsessor);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
        }
        //NyKomponentAlert.visBekreftelse(txtVaremerke.getText(), txtModell.getText());

        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

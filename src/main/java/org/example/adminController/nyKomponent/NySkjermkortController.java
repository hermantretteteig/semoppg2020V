package org.example.adminController.nyKomponent;


import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.komponent.Komponent;
import models.komponent.Skjermkort;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;

public class NySkjermkortController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblKlokkehastighetFeil;
    public Label lblMinneFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtKlokkehastighet;
    public TextField txtMinne;

    @FXML
    public AnchorPane skjermkortPanel;

    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblKlokkehastighetFeil.setText("");
        lblMinneFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");


        //Validerer Varenummer


        //Validerer Varemerke
        if(!BokstaverCheck.bokstavercheck(txtVaremerke.getText())){
            lblVaremerkeFeil.setText("Må kunne inneholde bokstaver");
        }

        //Validerer Modell
        if(!LengeCheck.lengdeCheck(txtModell.getText())){
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
        }

        //Validerer Pris
        if(!TallCheck.tallcheck(txtPris.getText())){
            lblPrisFeil.setText("Må inneholde kun tall");
        }
        double pris = Double.parseDouble(txtPris.getText());

        //Validerer klokkehastighet
        if(!TallCheck.tallcheck(txtKlokkehastighet.getText())) {
            lblKlokkehastighetFeil.setText("Må kun inneholde tall");
        }

        //Validerer Minne
        if(!TallCheck.tallcheck(txtMinne.getText())) {
            lblMinneFeil.setText("Må kun inneholde tall");
        }

        Skjermkort nyttSkjermkort = new Skjermkort(txtVaremerke.getText(),
                txtModell.getText(),
                Double.parseDouble(txtPris.getText()),
                Double.parseDouble(txtKlokkehastighet.getText()),
                Integer.parseInt(txtMinne.getText()));
        KomponentData.leggTilKomponent(nyttSkjermkort);

        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

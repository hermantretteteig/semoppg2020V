package org.example.adminController.nyKomponent;


import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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

    @FXML private javafx.scene.control.Button registrer;
    @FXML private javafx.scene.control.Button avslutt;

    @FXML
    public void leggTilAction() throws Exception {

        lblVaremerkeFeil.setText("");
        lblKlokkehastighetFeil.setText("");
        lblMinneFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String klokkehastighet = txtKlokkehastighet.getText();
        String minne = txtMinne.getText();
        String modell = txtModell.getText();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        //Validerer Varenummer

        //Validerer Varemerke
        if (LengeCheck.lengdeCheck(varemerke) == false) {
            lblVaremerkeFeil.setText("Må inneholde minst 2 bokstaver");
            check1 = false;
        }

        //Validerer Modell
        if (LengeCheck.lengdeCheck(modell) == false) {
            lblModellFeil.setText("Må inneholde minst 2 bokstaver");
            check2 = false;
        }

        //Validerer Pris
        if (TallCheck.tallcheck(txtPris.getText()) == false) {
            lblPrisFeil.setText("Må inneholde kun tall");
            check3 = false;
        }

        //Validerer klokkehastighet
        if (TallCheck.tallcheck(klokkehastighet) == false) {
            lblKlokkehastighetFeil.setText("Må kun inneholde tall");
            check4 = false;
        }

        //Validerer Minne
        if (TallCheck.tallcheck(minne) == false) {
            lblMinneFeil.setText("Må kun inneholde tall");
            check5 = false;
        }

        Skjermkort nyttSkjermkort = new Skjermkort(txtVaremerke.getText(),
                txtModell.getText(),
                Double.parseDouble(txtPris.getText()),
                Double.parseDouble(txtKlokkehastighet.getText()),
                Integer.parseInt(txtMinne.getText()));
        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nyttSkjermkort);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();

        }
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

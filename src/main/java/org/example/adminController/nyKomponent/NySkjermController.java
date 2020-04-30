package org.example.adminController.nyKomponent;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.App;
import validering.BokstaverCheck;
import validering.LengeCheck;
import validering.TallCheck;

public class NySkjermController {

    public Label lblVaremerkeFeil;
    public Label lblModellFeil;
    public Label lblPrisFeil;
    public Label lblHoydeFeil;
    public Label lblBreddeFeil;
    public Label lbl4KFeil;

    public TextField txtVaremerke;
    public TextField txtModell;
    public TextField txtPris;
    public TextField txtHoyde;
    public TextField txtBredde;
    public ChoiceBox cho4K;

    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblHoydeFeil.setText("");
        lblBreddeFeil.setText("");
        lbl4KFeil.setText("");

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

        //Validerer Bredde
        if(TallCheck.tallcheck(txtBredde.getText()) == false){
            lblBreddeFeil.setText("Må inneholde kun tall");
        }

        //Validerer Høyde
        if(TallCheck.tallcheck(txtHoyde.getText()) == false){
            lblHoydeFeil.setText("Må inneholde kun tall");
        }

        double pris = Double.parseDouble(txtPris.getText());

        //Validerer 4K
        if(cho4K.getValue() == null) {
            lbl4KFeil.setText("Må fylles ut");
        }
        
        //Mus nySkjerm = new Skjerm();
        //KomponentData.leggTilKomponent(nySkjerm);

        //Rooter tilslutt til oversiktview
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

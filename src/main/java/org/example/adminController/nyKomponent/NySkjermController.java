package org.example.adminController.nyKomponent;

import data.KomponentData;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logikk.NyKomponentAlert;
import models.komponent.Skjerm;
import org.example.App;
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

    @FXML public javafx.scene.control.Button registrer;
    @FXML public  javafx.scene.control.Button avslutt;

    @FXML
    public void avsluttAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void leggTilAction() throws Exception{

        lblVaremerkeFeil.setText("");
        lblModellFeil.setText("");
        lblPrisFeil.setText("");
        lblHoydeFeil.setText("");
        lblBreddeFeil.setText("");
        lbl4KFeil.setText("");

        String varemerke = txtVaremerke.getText();
        String modell = txtModell.getText();
        double pris = Double.parseDouble(txtPris.getText());
        String hoyde = txtHoyde.getText();
        String bredde = txtBredde.getText();

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

        //Validerer Bredde
        if(TallCheck.tallcheck(bredde) == false){
            lblBreddeFeil.setText("Må inneholde kun tall");
            check4 = false;
        }

        //Validerer Høyde
        if(TallCheck.tallcheck(hoyde) == false){
            lblHoydeFeil.setText("Må inneholde kun tall");
            check5 = false;
        }


        //Validerer 4K
        if(cho4K.getValue() == null) {
            lbl4KFeil.setText("Må fylles ut");
        }


        Skjerm nySkjerm = new Skjerm(varemerke, modell, pris,
                 Integer.parseInt(hoyde), Integer.parseInt(bredde));

        if (check1 && check2 && check3 && check4 && check5){
            KomponentData.leggTilKomponent(nySkjerm);
            Stage stage = (Stage) avslutt.getScene().getWindow();
            stage.close();
            NyKomponentAlert.visBekreftelse(varemerke, modell);
        }
        //App.setRoot("adminView/nyKomponentView/nyKomponent");
    }
}

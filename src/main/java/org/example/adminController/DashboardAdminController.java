package org.example.adminController;
import javafx.fxml.FXML;
import org.example.App;

public class DashboardAdminController {

    public void lagreAction() throws Exception{
        //File chooser åpnes
    }

    public void nyKomponentAction() throws Exception{
        App.setRoot("adminView/nyKomponentView/nyKomponent");
    }

    @FXML
    public void nyAdminAction() throws Exception{
        App.nyttLiteVindu("adminView/nyAdmin", "Legg til ny administrator", 344, 374);
    }

    @FXML
    public void endreKomponentAction() throws Exception{
        App.setRoot("adminView/endreKomponent/endreKomponent");
    }

    @FXML
    public void loggUtAction() throws Exception{
        //kode som avslutter session

        App.setRoot("loggInn");

    }
}

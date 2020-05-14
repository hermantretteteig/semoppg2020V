package filbehandling.Alerts;

import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class JobjAlerts {

    //Metode som kjøres når tråden som kjøres ved henting av fil utføres riktig.
    public static void suksessHentFil() {
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Henting av fil");
        alert.setHeaderText("Filen ble hentet.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();
    }

    //Metode som kjøres når tråden som kjøres ved henting av fil feiler
    public static void feiletHentFil() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes.\n\nSe konsollen for mer info.");
        alert.showAndWait();
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil utføres riktig.
    public static void suksessLagreFil() {
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Lagring av fil");
        alert.setHeaderText("Filen ble lagret.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();
    }

    //Metode som kjøres når tråden som kjøres ved lagring av fil feiler
    public void feiletLagreFil(){
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Lagring av fil feilet");
        alert.setHeaderText("Lagring av fil mislyktes.\n\nSe konsollen for mer info.");
        alert.showAndWait();
    }
}

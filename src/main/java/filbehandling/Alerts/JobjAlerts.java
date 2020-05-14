package filbehandling.Alerts;

import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/*
Denne klassen inneholder metoder som viser Alert-bokser ved lagring og henting av jobj-filer.
 */

public class JobjAlerts {

    public static void suksessHentFil() {
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Henting av fil");
        alert.setHeaderText("Filen ble hentet.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();
    }

    public static void feiletHentFil() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes.\n\nSe konsollen for mer info.");
        alert.showAndWait();
    }

    public static void suksessLagreFil() {
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Lagring av fil");
        alert.setHeaderText("Filen ble lagret.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();
    }

    public static void feiletLagreFil(){
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Lagring av fil feilet");
        alert.setHeaderText("Lagring av fil mislyktes.\n\nSe konsollen for mer info.");
        alert.showAndWait();
    }

    public static Alert bekreftHentFil(){
        ButtonType fortsett = new ButtonType("Fortsett", ButtonBar.ButtonData.OK_DONE);
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING, "", fortsett, avbryt);
        alert.setTitle("Hent fil");
        alert.setHeaderText("Alle endringer som ikke er lagret vil bli slettet.");
        alert.setContentText("Er du sikker på at du vil fortsette?");
        alert.showAndWait();

        return alert;
    }
}

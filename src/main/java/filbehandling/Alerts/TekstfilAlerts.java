package filbehandling.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class TekstfilAlerts {

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
    public static void feiletHentFilNumber() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av heltall. \nSe konsollen for mer info.");
        alert.showAndWait();
    }

    //Metode som kjøres når tråden som kjøres ved henting av fil feiler
    public static void feiletHentFilBoolean() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av desimaltall. \nSe konsollen for mer info");
        alert.showAndWait();
    }

    //Metode som kjøres når tråden som kjøres ved henting av fil feiler
    public static void feiletHentFilOrdre() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av ordre. Separer verdier med semikolon. \n\nSe konsollen for mer info.");
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
    public static void feiletLagreFil() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Lagring av fil feilet");
        alert.setHeaderText("Lagring av fil mislyktes");
        alert.setContentText("Trykk på knappen for å avbryte.");
        alert.showAndWait();
    }
}
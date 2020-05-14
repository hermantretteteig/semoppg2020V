package filbehandling.Varsler;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/*
Denne klassen inneholder metoder som viser Alert-bokser ved lagring og henting av tekstfiler.
 */

public class VarslerFilbehandling {

    public static void suksessHentFil() {
        ButtonType fortsett = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
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

    public static void feiletHentFilNumber() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av heltall. \nSe konsollen for mer info.");
        alert.showAndWait();
    }

    public static void feiletHentFilBoolean() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av desimaltall. \nSe konsollen for mer info");
        alert.showAndWait();
    }

    public static void feiletHentFilOrdre() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setHeight(300);
        alert.setTitle("Henting av fil feilet");
        alert.setHeaderText("Henting av fil mislyktes");
        alert.setContentText("Feil format på filen. Feilen oppsto under formatering av ordre. Separer verdier med semikolon. \n\nSe konsollen for mer info.");
        alert.showAndWait();
    }

    public static void suksessLagreFil() {
        ButtonType fortsett = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", fortsett);
        alert.setTitle("Lagring av fil");
        alert.setHeaderText("Filen ble lagret.");
        alert.setContentText("Trykk på knappen for å fortsette.");
        alert.showAndWait();
    }

    public static void feiletLagreFil() {
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, "", avbryt);
        alert.setTitle("Lagring av fil feilet");
        alert.setHeaderText("Lagring av fil mislyktes");
        alert.setContentText("Trykk på knappen for å avbryte.");
        alert.showAndWait();
    }

    public static Alert bekreftHentFil(){
        ButtonType fortsett = new ButtonType("Ja", ButtonBar.ButtonData.OK_DONE);
        ButtonType avbryt = new ButtonType("Avbryt", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING, "", fortsett, avbryt);
        alert.setTitle("Hent fil");
        alert.setHeaderText("Alle endringer som ikke er lagret vil bli slettet.");
        alert.setContentText("Er du sikker på at du vil fortsette?");
        alert.showAndWait();

        return alert;
    }
}

package logikk;

public class Advarsel {

    public static void informasjonsAlert(String tittel, String header, String detaljer) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(tittel);
        alert.setHeaderText(header);
        alert.setContentText(detaljer);
        alert.showAndWait();

    }
}

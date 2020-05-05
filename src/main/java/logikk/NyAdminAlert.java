package logikk;

import javafx.scene.control.Alert;

public class NyAdminAlert {
    public static void visBekreftelse(String brukernavn) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ny Admin opprettet");
        alert.setHeaderText(brukernavn + " er registrert.");
        alert.setContentText("For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        alert.showAndWait();
    }
}

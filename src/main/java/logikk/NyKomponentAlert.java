package logikk;

import javafx.scene.control.Alert;

public class NyKomponentAlert {
    public static void visBekreftelse(String varemerke, String modell){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wooops!");
        alert.setHeaderText(varemerke+" "+modell+" er registrert.");
        alert.setContentText("For å lagre til fil klikk <Eksporter fil> i Administratordashboard");
        alert.showAndWait();

    }
}

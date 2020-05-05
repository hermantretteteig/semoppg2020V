package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.brukere.Kunde;

public class KundeData {
    private static ObservableList<Kunde> kunder = FXCollections.observableArrayList();

    public static ObservableList<Kunde> getKunder() {
        return kunder;
    }

    public static Kunde getKunde(String kundenr){
        Kunde kunde = null;
        for (Kunde enKunde : kunder) {
            if (kundenr.equals(enKunde.getKundenummer())) {
                kunde = enKunde;
            }
        }
        return kunde;
    }

    public void hentAlleKunder(TableView tv) {
        tv.setItems(kunder);
    }

    public static void setKunder(ObservableList<Kunde> kunder) {
        KundeData.kunder = kunder;
    }

    public static void leggTilKunde(Kunde nyKunde){
        kunder.add(nyKunde);
    }
}

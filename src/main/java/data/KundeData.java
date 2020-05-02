package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.brukere.Kunde;
import models.komponent.Komponent;

public class KundeData {
    private static ObservableList<Kunde> kunder = FXCollections.observableArrayList();

    public static ObservableList<Kunde> getKunder() {
        return kunder;
    }

    public static void setKunder(ObservableList<Kunde> kunder) {
        KundeData.kunder = kunder;
    }

    public static void leggTilKunde(Kunde nyKunde){
        kunder.add(nyKunde);
    }
}

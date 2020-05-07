package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

public class ValgtOrdreSinDatamaskinData {
    private static ObservableList<Komponent> datamaskinen = FXCollections.observableArrayList();

    public void hentValgtDatamaskin(TableView tv, Ordre valgtOrdre) {
        datamaskinen.clear();
        datamaskinen.addAll(valgtOrdre.getDatamaskin().getSkjermkort(), valgtOrdre.getDatamaskin().getLagringsenhet(),
        valgtOrdre.getDatamaskin().getMus(), valgtOrdre.getDatamaskin().getProsessor(), valgtOrdre.getDatamaskin().getSkjerm(),
        valgtOrdre.getDatamaskin().getTastatur());

        tv.setItems(datamaskinen);
    }

    public static void leggTil(Komponent nyKomponent) {
        datamaskinen.add(nyKomponent);
    }
}

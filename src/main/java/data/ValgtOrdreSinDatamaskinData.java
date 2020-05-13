package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;
import models.komponent.Komponent;

public class ValgtOrdreSinDatamaskinData {
    private static ObservableList<Komponent> datamaskinSineKomponenter = FXCollections.observableArrayList();

    //Henter frem ordre sine komponenter. Disse komponentene legges til i listen datamaskinSineKomponenter.
    //Denne listen over komponenter blir synelig i viewet når ordren er valgt.
    public void hentValgtDatamaskin(TableView tv, Ordre valgtOrdre) {
        datamaskinSineKomponenter.clear();
        //Legger til komponentene til datamaskinen i ordren i listen.
        datamaskinSineKomponenter.addAll(valgtOrdre.getDatamaskin().getSkjermkort(), valgtOrdre.getDatamaskin().getLagringsenhet(),
        valgtOrdre.getDatamaskin().getMus(), valgtOrdre.getDatamaskin().getProsessor(), valgtOrdre.getDatamaskin().getSkjerm(),
        valgtOrdre.getDatamaskin().getTastatur());

        tv.setItems(datamaskinSineKomponenter);
    }

    public static void leggTil(Komponent nyKomponent) {
        datamaskinSineKomponenter.add(nyKomponent);
    }
}

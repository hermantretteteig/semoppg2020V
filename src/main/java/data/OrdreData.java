package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;

import java.util.ArrayList;

public class OrdreData {
    public static void setOrdre(ObservableList<Ordre> ordre) {
        OrdreData.ordre = ordre;
    }

    private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();

    public static ObservableList<Ordre> getOrdre() {
        return ordre;
    }

    //Metode som henter alle ordre i listen og returnerer som arraylist
    public static ArrayList<Ordre> getOrdreArray() {
        return new ArrayList<>(ordre);
    }

    //Legger til en ny ordre
    public static void leggTilOrdre(Ordre nyOrdre) {
        ordre.add(nyOrdre);
    }

    public static void setAlleOrdre(ArrayList<Ordre> ordre) {
        OrdreData.ordre = FXCollections.observableArrayList(ordre);
    }

    //Henter listen over alle ordre og sender denne til tabellviewt.
    public void hentAlleOrdre(TableView tv) {
        tv.setItems(ordre);
    }

    //Henter ordrene til den innlogget kunden, og legger dette til viewet.
    public void hentKundensOrdre(TableView tv) {
        ObservableList<Ordre> kundensOrdre = FXCollections.observableArrayList();

        for(Ordre ordre : ordre){
            if(ordre.getKundenr().equals(InnloggetBrukerData.getInnloggetKunde().getKundenummer())){
                kundensOrdre.add(ordre);
            }
        }
        tv.setItems(kundensOrdre);



    }
}




package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;

import java.util.ArrayList;

public class OrdreData {
    private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();
    private static ObservableList<Ordre> kundensOrdre = FXCollections.observableArrayList();


    public static ObservableList<Ordre> getOrdre() {
        return ordre;
    }


    public static ArrayList<Ordre> getOrdreListe() {
        return new ArrayList<>(ordre);
    }

    public static void leggTilOrdre(Ordre nyOrdre) {
        ordre.add(nyOrdre);
    }

    public static void setAlleOrdre(ArrayList<Ordre> ordre) {
        OrdreData.ordre = FXCollections.observableArrayList(ordre);
    }

    public void hentAlleOrdre(TableView tv) {
        tv.setItems(ordre);
    }


    public void hentKundensOrdre(TableView tv) {

        ObservableList<Ordre> kundensOrdre = FXCollections.observableArrayList();

        for(Ordre ordre : ordre){
            /*System.out.println(ordre.getKundenr());
            System.out.println(InnloggetKundeData.getInnloggetKunde().getKundenummer());*/

            if(ordre.getKundenr().equals(InnloggetBrukerData.getInnloggetKunde().getKundenummer())){
                kundensOrdre.add(ordre);
            }
        }
        tv.setItems(kundensOrdre);



    }
}




package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;
import models.komponent.Komponent;

import java.util.ArrayList;

public class OrdreData {
    private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();

    public static ObservableList<Ordre> getOrdre() {
        return ordre;
    }

    public static ArrayList<Ordre> getOrdreListe(){
        return new ArrayList<>(ordre);
    }

    public static void leggTilOrdre(Ordre nyOrdre){
        ordre.add(nyOrdre);
    }

    public static void setAlleOrdre(ArrayList<Ordre> ordre) {
        OrdreData.ordre = FXCollections.observableArrayList(ordre);
    }

    public void hentKomponenttype(TableView tv) {
        tv.setItems(ordre);
    }
    }


package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.komponent.Komponent;

import java.io.Serializable;

public class KomponentData implements Serializable {
    private static ObservableList<Komponent> alleKomponenter = FXCollections.observableArrayList();

    public KomponentData() {
    }

    public static ObservableList<Komponent> getAlleKomponenter() {
        return alleKomponenter;
    }

    public static void setAlleKomponenter(ObservableList<Komponent> alleKomponenter) {
        KomponentData.alleKomponenter = alleKomponenter;
    }

    public static void leggTilKomponent(Komponent nyKomponent){
        alleKomponenter.add(nyKomponent);
    }

    public static Komponent hentMedVarenummer(int varenummer){

        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().equals(varenummer)){
                return enKomponent;
            }
        }
        return null;
    }

    public static void slettMedVarenummer(int varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().equals(varenummer)){
                alleKomponenter.remove(enKomponent);
            }
        }
    }
    }

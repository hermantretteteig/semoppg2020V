package data;

import javafx.collections.ObservableList;
import models.komponent.Komponent;

public class KomponentData {
    private static ObservableList<Komponent> alleKompenter;

    public static ObservableList<Komponent> getAlleKompenter() {
        return alleKompenter;
    }

    public static void setAlleKompenter(ObservableList<Komponent> alleKompenter) {
        KomponentData.alleKompenter = alleKompenter;
    }

    public static void leggTilKomponent(Komponent nyKomponent){
        alleKompenter.add(nyKomponent);
    }

    public static Komponent hentMedVarenummer(int varenummer){

        for (Komponent enKomponent : alleKompenter){
            if(enKomponent.getVarenr().equals(varenummer)){
                return enKomponent;
            }
        }
        return null;
    }

    public static void slettMedVarenummer(int varenummer){
        for (Komponent enKomponent : alleKompenter){
            if(enKomponent.getVarenr().equals(varenummer)){
                alleKompenter.remove(enKomponent);
            }
        }
    }
    }

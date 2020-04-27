package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.komponent.Komponent;

import java.util.ArrayList;

public class KomponentData {
    private static ObservableList<Komponent> alleKomponenter = FXCollections.observableArrayList();

    public static ObservableList<Komponent> getAlleKomponenter() {
        return alleKomponenter;
    }

    public static void setAlleKomponenter(ArrayList<Komponent> alleKomponenter) {
        KomponentData.alleKomponenter = FXCollections.observableArrayList(alleKomponenter);
    }

    public static void leggTilKomponent(Komponent nyKomponent){
        alleKomponenter.add(nyKomponent);
    }

    public static Komponent hentMedVarenummer(String varenummer){

        SimpleStringProperty sspVarenummer = new SimpleStringProperty(varenummer);
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().equals(sspVarenummer)){
                return enKomponent;
            }
        }
        return null;
    }

    public static void slettMedVarenummer(SimpleStringProperty varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().equals(varenummer)){
                alleKomponenter.remove(enKomponent);
            }
        }
    }
    }

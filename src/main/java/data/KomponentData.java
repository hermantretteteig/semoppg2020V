package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
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

   /* public static Komponent hentMedVarenummer(String varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().get().equals(varenummer)){
                return  enKomponent;
            }
        }
        return null;
    }*/

    public void attachTableView(TableView tv) {
        tv.setItems(alleKomponenter);
    }

    /*public static void slettMedVarenummer(String varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().get().equals(varenummer)){
                alleKomponenter.remove(enKomponent);
            }
        }
    }*/
    }

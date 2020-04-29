package data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import models.komponent.Komponent;
import models.komponent.Lagringsenhet;
import models.komponent.Tastatur;

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


    public void hentKomponenttype(TableView tv, String enhet) {
        ObservableList<Komponent> utvalgteLagrinsenheter = FXCollections.observableArrayList();
        for(Komponent enKomponent : alleKomponenter){
            if(enKomponent.getClass().getSimpleName().equals(enhet)){
                utvalgteLagrinsenheter.add(enKomponent);
            }
        }
        tv.setItems(utvalgteLagrinsenheter);
    }

    /*public static void slettMedVarenummer(String varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().get().equals(varenummer)){
                alleKomponenter.remove(enKomponent);
            }
        }
    }*/
    }

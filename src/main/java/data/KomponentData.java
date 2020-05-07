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

        if(enhet.equals("Vis alle")){
            utvalgteLagrinsenheter = alleKomponenter;
        }

        for(Komponent enKomponent : alleKomponenter){
            if(enKomponent.getClass().getSimpleName().equals(enhet)){
                utvalgteLagrinsenheter.add(enKomponent);
            }
        }
        tv.setItems(utvalgteLagrinsenheter);
    }

    public void sorterEtterPris(TableView tv, double prisFra, double prisTil, String enhet){
        ObservableList<Komponent> returListe = FXCollections.observableArrayList();
        for(Komponent enKomponent : alleKomponenter){
            //Sjekker om prisen er innenfor grensene
            if(enKomponent.getPris()>=prisFra && enKomponent.getPris()<=prisTil){
                //Sjekker om brukeren har valgt "Vis alle", og hvis ja legger til objektet i lista
                if(enhet.equals("Vis alle")){
                    returListe.add(enKomponent);
                }
                //Sjekker om komponenten er lik komponenttypen som er valgt i valgboksen
                if(enKomponent.getClass().getSimpleName().equals(enhet)){
                    returListe.add(enKomponent);
                }

            }
        }
        tv.setItems(returListe);
    }

    /*public static void slettMedVarenummer(String varenummer){
        for (Komponent enKomponent : alleKomponenter){
            if(enKomponent.getVarenr().get().equals(varenummer)){
                alleKomponenter.remove(enKomponent);
            }
        }
    }*/
    }

package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.komponent.*;

public class HandlekurvData {
    private static ObservableList<Komponent> handlekurv = FXCollections.observableArrayList();
    private static Double sumHandlekurv = 0.0;

    public static ObservableList<Komponent> getHandlekurv() {
        return handlekurv;
    }
    public static Double getSumHandlekurv() {
        return sumHandlekurv;
    }
    public static void setSumHandlekurv(Double sumHandlekurv) {
        HandlekurvData.sumHandlekurv = sumHandlekurv;
    }

    //Ut av komponentene som er lagt til i handlekurven opprettes det en datamaskin.
    public static Datamaskin genererDatamaskinAvHandlekurv() throws CloneNotSupportedException {
        Lagringsenhet nyLagringsenhet = null;
        Mus nyMus = null;
        Prosessor nyProsessor = null;
        Skjerm nySkjerm = null;
        Skjermkort nySkjermkort = null;
        Tastatur nyTastatur = null;

        /*
        Metoden går igjennom listen av komponenter som ligger i handlekurven. Simpelnavnet til komponentene bestemmer hvilken
        komponent som skal castes og videre legges til i konstruktøren til datamaskinobjektet.
         */


        for(Komponent enVare : handlekurv){
            if(enVare.getClass().getSimpleName().equals("Lagringsenhet")){
                nyLagringsenhet = (Lagringsenhet) enVare.clone();
            }
            if(enVare.getClass().getSimpleName().equals("Mus")){
                nyMus = (Mus) enVare.clone();
            }
            if(enVare.getClass().getSimpleName().equals("Prosessor")){
                nyProsessor = (Prosessor) enVare.clone();
            }
            if(enVare.getClass().getSimpleName().equals("Skjerm")){
                nySkjerm = (Skjerm) enVare.clone();
            }
            if(enVare.getClass().getSimpleName().equals("Skjermkort")){
                nySkjermkort = (Skjermkort) enVare.clone();
            }
            if(enVare.getClass().getSimpleName().equals("Tastatur")){
                nyTastatur = (Tastatur) enVare.clone();
            }
        }

        //Datamaskinen generet fra handlekurven klones til en ny datamaskin
        Datamaskin nyDatamaskin = new Datamaskin(nyProsessor, nySkjermkort, nyLagringsenhet, nySkjerm, nyMus, nyTastatur).clone();
        return nyDatamaskin;
    }

    public static void setHandlekurv(ObservableList<Komponent> handlekurv) {
        HandlekurvData.handlekurv = handlekurv;
    }

    //Henter handlekurven til tabellen
    public void hentKomponenttype(TableView tv){
        tv.setItems(handlekurv);
    }

    //Legger til ny komponent i handlekurven
    public static void nyVare(Komponent nyVare){
        handlekurv.add(nyVare);
        //Summerer inn komonentens pris
        sumHandlekurv += nyVare.getPris();
    }


    public static void slettKomponent(String varetype){
        Komponent slettVare = null;
        for(Komponent enVare : handlekurv){
            if(varetype.equals(enVare.getClass().getSimpleName())){
                slettVare = enVare;
            }
        }
        //Trekker fra prisen til komponenten i totalprisen
        sumHandlekurv -= slettVare.getPris();
        handlekurv.remove(slettVare);

    }
}

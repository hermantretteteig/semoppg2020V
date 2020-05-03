package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import models.komponent.*;

public class HandlekurvData {
    private static ObservableList<Komponent> handekurv = FXCollections.observableArrayList();
    private static Double sumHandlkurv = 0.0;

    public static ObservableList<Komponent> getHandekurv() {
        return handekurv;
    }

    public static void setHandekurv(ObservableList<Komponent> handekurv) {
        HandlekurvData.handekurv = handekurv;
    }

    public static Double getSumHandlkurv() {
        return sumHandlkurv;
    }

    public static void setSumHandlkurv(Double sumHandlkurv) {
        HandlekurvData.sumHandlkurv = sumHandlkurv;
    }



    public static Datamaskin genererDatamaskinAvHandlekurv(){
        Lagringsenhet nyLagringsenhet = null;
        Mus nyMus = null;
        Prosessor nyProsessor = null;
        Skjerm nySkjerm = null;
        Skjermkort nySkjermkort = null;
        Tastatur nyTastatur = null;

        for(Komponent enVare : handekurv){
            if(enVare.getClass().getSimpleName().equals("Lagringsenhet")){
                nyLagringsenhet = (Lagringsenhet) enVare;
            }
            if(enVare.getClass().getSimpleName().equals("Mus")){
                nyMus = (Mus) enVare;
            }
            if(enVare.getClass().getSimpleName().equals("Prosessor")){
                nyProsessor = (Prosessor) enVare;
            }
            if(enVare.getClass().getSimpleName().equals("Skjerm")){
                nySkjerm = (Skjerm) enVare;
            }
            if(enVare.getClass().getSimpleName().equals("Skjermkort")){
                nySkjermkort = (Skjermkort) enVare;
            }
            if(enVare.getClass().getSimpleName().equals("Tastatur")){
                nyTastatur = (Tastatur) enVare;
            }
        }

        Datamaskin nyDatamaskin = new Datamaskin(nyProsessor, nySkjermkort, nyLagringsenhet, nySkjerm, nyMus, nyTastatur);
        return nyDatamaskin;
    }

    public void hentKomponenttype(TableView tv){
        tv.setItems(handekurv);
    }

    public static void nyVare(Komponent nyVare){
        handekurv.add(nyVare);
        sumHandlkurv = sumHandlkurv + nyVare.getPris();

    }


    public static void slettType(String varetype){
        Komponent slettVare = null;
        for(Komponent enVare : handekurv){
            if(varetype.equals(enVare.getClass().getSimpleName())){
                slettVare = enVare;
                //break;
            }
        }
        sumHandlkurv = sumHandlkurv - slettVare.getPris();
        handekurv.remove(slettVare);

    }
}

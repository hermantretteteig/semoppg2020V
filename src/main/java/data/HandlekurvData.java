package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.komponent.Komponent;

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

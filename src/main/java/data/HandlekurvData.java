package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.HandlekurvVare;

public class HandlekurvData {
    private static ObservableList<HandlekurvVare> handekurv = FXCollections.observableArrayList();

    public static ObservableList<HandlekurvVare> getHandekurv() {
        return handekurv;
    }

    public static void setHandekurv(ObservableList<HandlekurvVare> handekurv) {
        HandlekurvData.handekurv = handekurv;
    }

    public void hentKomponenttype(TableView tv){
        tv.setItems(handekurv);
    }

    public static void nyVare(HandlekurvVare nyVare){
        handekurv.add(nyVare);
    }

    public static void slettType(String varetype){
        for(HandlekurvVare enVare : handekurv){
            if(varetype.equals(enVare.getType())){
                handekurv.remove(enVare);
                break;
            }
        }
    }
}

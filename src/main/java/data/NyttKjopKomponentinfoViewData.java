package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.HandlekurvVare;
import models.NyttKjopKomponentinfoView;
import models.komponent.Komponent;
import models.komponent.Lagringsenhet;
import models.komponent.Prosessor;

public class NyttKjopKomponentinfoViewData {
    private static ObservableList<NyttKjopKomponentinfoView> komponentinfo = FXCollections.observableArrayList();

    public static ObservableList<NyttKjopKomponentinfoView> getKomponentinfo() {
        return komponentinfo;
    }

    public static void setKomponentinfo(ObservableList<NyttKjopKomponentinfoView> komponentinfo) {
        NyttKjopKomponentinfoViewData.komponentinfo = komponentinfo;
    }

    public void hentKomponentinfo(TableView tv){
        tv.setItems(komponentinfo);
    }

    public static void nyVerdi(NyttKjopKomponentinfoView nyVare){
        komponentinfo.add(nyVare);
    }

    public static void OppdaterView(Komponent valgtKomponent){
        komponentinfo.clear();
        String komponenttype = valgtKomponent.getClass().getSimpleName();

        for(Komponent enKomponent : KomponentData.getAlleKomponenter()){
            if(enKomponent.getClass().getSimpleName().equals("Lagringsenhet") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Lagringsenhet nyLagrinsenhet = (Lagringsenhet) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Format", nyLagrinsenhet.getFormat());
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Gb", (String.valueOf(nyLagrinsenhet.getGb())));
                NyttKjopKomponentinfoView nyVerdi3 = new NyttKjopKomponentinfoView("Skrivehastighet (MB/s)", nyLagrinsenhet.getLeseHastighet());
                NyttKjopKomponentinfoView nyVerdi4 = new NyttKjopKomponentinfoView("Lesehastighet (MB/s)", nyLagrinsenhet.getSkriveHastighet());
                komponentinfo.addAll(nyVerdi1, nyVerdi2, nyVerdi3, nyVerdi4);
            }
        }
        for(Komponent enKomponent : KomponentData.getAlleKomponenter()){
            if(enKomponent.getClass().getSimpleName().equals("Prosessor") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Prosessor nyLagrinsenhet = (Prosessor) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Antall kjerner:", String.valueOf(nyLagrinsenhet.getAntallKjerner()));
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Klokkehstighet (GHz)", String.valueOf(nyLagrinsenhet.getKlokkehastighet()));
                komponentinfo.addAll(nyVerdi1, nyVerdi2);
            }
        }
    }

}

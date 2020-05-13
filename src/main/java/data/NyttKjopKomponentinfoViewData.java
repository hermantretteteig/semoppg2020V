package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.komponent.Komponent;
import models.NyttKjopKomponentinfoView;
import models.komponent.*;

/*
Denne klassen generer et listeview ut fra detaljene om komponenten. Listen består av to kollonner der
første kollonne beskriver detaljen (f. eks. lagringsplass, antall kjerner, prosessorhastighet), mens
den andre kollonen beskriver verdien til detaljen. Denne listen brukes i handlekurven og tidligere kjøp
der brukeren har mulighet til å få mer informasjon om de ulike komponentene.
*/


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

    //Klassen som genererer listeviewet bestående av kollonnene "detalje" og "verdi av detalje".
    // For eks. "Lagringsformat SSS)
    public static void OppdaterView(Komponent valgtKomponent){
        //Tømmer listen som vises i viewet, hvis det har vært hentet inn komponentinformasjon tidligere.
        komponentinfo.clear();

        //Går igjennom listen og lager objekter (bestående av "detalje" og "verdi av detalje") som vises i listen.
        for(Komponent enKomponent : KomponentData.getKomponenter()){

            //Hvis "Lagringsenhet" er valgt generes lagrinsenheter sine detaljer. Disse detaljeobjektene legger til i listen over detaljer.
            if(enKomponent.getClass().getSimpleName().equals("Lagringsenhet") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Lagringsenhet nyLagrinsenhet = (Lagringsenhet) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Lagringsformat", nyLagrinsenhet.getFormat());
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Kapsasitet (Gb)", (String.valueOf(nyLagrinsenhet.getGb())));
                NyttKjopKomponentinfoView nyVerdi3 = new NyttKjopKomponentinfoView("Lesehastighet (MB/s)", nyLagrinsenhet.getLeseHastighet());
                NyttKjopKomponentinfoView nyVerdi4 = new NyttKjopKomponentinfoView("Skrivehastighet (MB/s)", nyLagrinsenhet.getSkriveHastighet());
                komponentinfo.addAll(nyVerdi1, nyVerdi2, nyVerdi3, nyVerdi4);
            }

            //Samme prinsipper som if-setningen over.
            if(enKomponent.getClass().getSimpleName().equals("Mus") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Mus nyLagrinsenhet = (Mus) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Farge", nyLagrinsenhet.getFarge());
                String trodlos = "Nei";
                if(nyLagrinsenhet.getTrodlos()==true){
                    trodlos = "Ja";
                }
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Trådløs", trodlos);
                komponentinfo.addAll(nyVerdi1, nyVerdi2);
            }

            //Samme prinsipper som if-setningen over.
            if(enKomponent.getClass().getSimpleName().equals("Prosessor") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Prosessor nyLagrinsenhet = (Prosessor) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Antall kjerner", String.valueOf(nyLagrinsenhet.getAntallKjerner()));
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Klokkehastighet (GHz)", String.valueOf(nyLagrinsenhet.getKlokkehastighet()));
                komponentinfo.addAll(nyVerdi1, nyVerdi2);
            }

            //Samme prinsipper som if-setningen over.
            if(enKomponent.getClass().getSimpleName().equals("Skjerm") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Skjerm nyLagrinsenhet = (Skjerm) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Pikseler bredde:", String.valueOf(nyLagrinsenhet.getPixelBredde()));
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Piksler høyde;", String.valueOf(nyLagrinsenhet.getPixelHoyde()));
                String s4k = "Nei";
                if(nyLagrinsenhet.getMin4K()==true){
                    s4k = "Ja";
                }
                NyttKjopKomponentinfoView nyVerdi3 = new NyttKjopKomponentinfoView("4K: ", s4k);
                komponentinfo.addAll(nyVerdi1, nyVerdi2, nyVerdi3);
            }

            //Samme prinsipper som if-setningen over.
            if(enKomponent.getClass().getSimpleName().equals("Skjermkort") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Skjermkort nyLagrinsenhet = (Skjermkort) enKomponent;
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Minne:", String.valueOf(nyLagrinsenhet.getMinne()));
                NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Klokkehstighet (GHz)", String.valueOf(nyLagrinsenhet.getKlokkehastighet()));
                komponentinfo.addAll(nyVerdi1, nyVerdi2);
            }

            //Samme prinsipper som if-setningen over.
            if(enKomponent.getClass().getSimpleName().equals("Tastatur") && enKomponent.getVarenr().equals(valgtKomponent.getVarenr())){
                Tastatur nyttTastatur = (Tastatur) enKomponent;
                String numpad = "Nei";
                if(nyttTastatur.getNumpad()==true){
                    numpad = "Ja";
                }
                NyttKjopKomponentinfoView nyVerdi1 = new NyttKjopKomponentinfoView("Numpad ", numpad);
                String trodlos = "Nei";
                if(nyttTastatur.getTrodlos()==true){
                    trodlos = "Ja";
                }NyttKjopKomponentinfoView nyVerdi2 = new NyttKjopKomponentinfoView("Trådløs ", trodlos);
                komponentinfo.addAll(nyVerdi1, nyVerdi2);
            }
        }


    }

}

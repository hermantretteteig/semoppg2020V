package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.komponent.Komponent;

import java.util.ArrayList;

public class KomponentData {
    private static ObservableList<Komponent> komponenter = FXCollections.observableArrayList();

    //Metode som henter alle komponentene i listen
    public static ObservableList<Komponent> getKomponenter() {
        return komponenter;
    }

    //Metode som henter alle komponentene i listen og returnerer som arraylist
    public static ArrayList<Komponent> getKomponentArray() {
        return new ArrayList<>(komponenter);
    }

    /*public static void setKomponenter(ArrayList<Komponent> komponenter) {
        KomponentData.komponenter = FXCollections.observableArrayList(komponenter);
    }*/

    //Legger til en ny komponent når dette opprettes
    public static void leggTilKomponent(Komponent nyKomponent){
        komponenter.add(nyKomponent);
    }

    public static void setKomponenter(ObservableList<Komponent> alleKomponenter) {
        KomponentData.komponenter = alleKomponenter;
    }

    public static void slettKomponent(Komponent selectedItem) {
        komponenter.remove(selectedItem);
    }

    /*
    Brukes i viewt til endre komponenter. Metoden filtrerer ut de komponetenene som ikke samvarer med den
    komponenten brukeren ønsker å vise i viewt.
     */
    public void hentKomponenttype(TableView tv, String enhet) {
        ObservableList<Komponent> valgtKomponent = FXCollections.observableArrayList();

        //Hvis brukeren har valgt valget "Vis alle" skal alle komponentene hentes til viewet.
        if(enhet.equals("Vis alle")){
            valgtKomponent = komponenter;
        }

        //Går igjennom listen over komponentene og filtrerer ut de som ikke samsvarer med komponenten brukeren har valgt
        for(Komponent enKomponent : komponenter){
            if(enKomponent.getClass().getSimpleName().equals(enhet)){
                valgtKomponent.add(enKomponent);
            }
        }
        tv.setItems(valgtKomponent);
    }

    /*
    Metoden fungerer i stor grad likt som metoden over. Forskjellen er at metoden også tar hensyn til at prisen til
    komponenten skal være innenfor to grenseverdier.
    */

    public void filtrerPris(TableView tv, double prisFra, double prisTil, String enhet){
        ObservableList<Komponent> returListe = FXCollections.observableArrayList();
        for(Komponent enKomponent : komponenter){
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
}

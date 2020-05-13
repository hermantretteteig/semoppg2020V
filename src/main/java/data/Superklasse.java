package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.brukere.Admin;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.Komponent;

import java.util.ArrayList;

public class Superklasse {
    private static ObservableList<Admin> admins = FXCollections.observableArrayList();
    private static ObservableList<Kunde> kunder = FXCollections.observableArrayList();
    private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();
    private static ObservableList<Komponent> komponenter = FXCollections.observableArrayList();


    public Superklasse() {
        admins = AdminData.getAdminer();
        kunder = KundeData.getKunder();
        ordre = OrdreData.getOrdre();
        komponenter = KomponentData.getKomponenter();
    }

    public static void hentFraFil(ArrayList<Admin> admins, ArrayList<Kunde> kunder, ArrayList<Ordre> ordre, ArrayList<Komponent> komponenter){
        AdminData.setAdmins(FXCollections.observableArrayList(admins));
        KundeData.setKunder(FXCollections.observableArrayList(kunder));
        OrdreData.setOrdre(FXCollections.observableArrayList(ordre));
        KomponentData.setAlleKomponenter(FXCollections.observableArrayList(komponenter));
    }
}

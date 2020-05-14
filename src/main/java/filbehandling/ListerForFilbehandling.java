package filbehandling;

import data.AdminData;
import data.KomponentData;
import data.KundeData;
import data.OrdreData;
import javafx.collections.FXCollections;
import models.brukere.Admin;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.Komponent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
Denne klassen eksisterer for å samle alle lister som skal lagres til fil på ett sted, slik at denne operasjonen kan
gjøres i ett steg.
 */

public class ListerForFilbehandling implements Serializable {
    private static final long serialVersionUID = 1;

    private static ArrayList<Admin> admins;
    private static ArrayList<Kunde> kunder;
    private static ArrayList<Ordre> ordre;
    private static ArrayList<Komponent> komponenter;

    public ListerForFilbehandling() {
        admins = AdminData.getAdminArray();
        kunder = KundeData.getKundeArray();
        ordre = OrdreData.getOrdreArray();
        komponenter = KomponentData.getKomponentArray();
    }

    //Setter listene i data klassene lik listene som er hentet fra fil.
    public void setDataFraFil(){
        AdminData.setAdmins(FXCollections.observableArrayList(admins));
        KundeData.setKunder(FXCollections.observableArrayList(kunder));
        OrdreData.setOrdre(FXCollections.observableArrayList(ordre));
        KomponentData.setKomponenter(FXCollections.observableArrayList(komponenter));
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(admins);
        out.writeObject(kunder);
        out.writeObject(ordre);
        out.writeObject(komponenter);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        admins = (ArrayList<Admin>) in.readObject();
        kunder = (ArrayList<Kunde>) in.readObject();
        ordre = (ArrayList<Ordre>) in.readObject();
        komponenter = (ArrayList<Komponent>) in.readObject();
    }
}

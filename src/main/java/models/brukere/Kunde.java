package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

/*
Kunde arver fra superklasse bruker. SimpleProperty blir brukt ettersom dette støttes av JavaFX tableview.
 */

public class Kunde extends Bruker {
    private transient SimpleStringProperty kundenummer;
    private transient SimpleStringProperty epost;

    //Konstruktør for oppretting av ny kunde
    public Kunde(String fornavn, String etternavn, String brukernavn, String passord, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.kundenummer = new SimpleStringProperty(genererKundenr());
        this.epost = new SimpleStringProperty(epost);
    }

    //TODO erstatte metoden i eksdata med den orginale?
    //Konstruktør for oppretting av kunde fra eksempeldata
    public Kunde(String fornavn, String etternavn, String brukernavn, String passord, String kundenummer, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.kundenummer = new SimpleStringProperty(kundenummer);
        this.epost = new SimpleStringProperty(epost);
    }

    public String getKundenummer() {
        return kundenummer.get();
    }

    public void setKundenummer(String kundenummer) {

        this.kundenummer.set(kundenummer);
    }

    public String getEpost() {
        return epost.get();
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    //Generer et kundenummer ved bruk av UUID
    private String genererKundenr() {
        return "KUNDE-"+UUID.randomUUID().toString();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(kundenummer.get());
        out.writeObject(epost.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        kundenummer = new SimpleStringProperty((String) in.readObject());
        epost = new SimpleStringProperty((String) in.readObject());
    }
}

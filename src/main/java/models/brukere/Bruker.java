package models.brukere;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
SimpleProperty blir brukt ettersom dette støttes direkte med tabelview fra JavaFX. Kunde og Admin arver fra
denne klassen.
 */


public class Bruker implements Serializable {
    private static final long serialVersionUID = 1;

    private transient SimpleStringProperty fornavn;
    private transient SimpleStringProperty etternavn;
    private transient SimpleStringProperty brukernavn;
    private transient SimpleStringProperty passord;

    public Bruker(String fornavn, String etternavn, String brukernavn, String passord) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.brukernavn = new SimpleStringProperty(brukernavn);
        this.passord = new SimpleStringProperty(passord);
    }

    public String getFornavn() {
        return fornavn.get();
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEtternavn() {
        return etternavn.get();
    }

    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }

    public String getBrukernavn() {
        return brukernavn.get();
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn.set(brukernavn);
    }

    public String getPassord() {
        return passord.get();
    }

    public void setPassord(String passord) {
        this.passord.set(passord);
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleStringProperties, da det ikke støttes som standard. Sørger for at, disse
    lagres som String istedet.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(fornavn.get());
        out.writeObject(etternavn.get());
        out.writeObject(brukernavn.get());
        out.writeObject(passord.get());
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleStringProperties, da det ikke støttes som standard. Konverterer
    String til SimpleStringProperty når de leses fra fil.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        fornavn = new SimpleStringProperty((String) in.readObject());
        etternavn = new SimpleStringProperty((String) in.readObject());
        brukernavn = new SimpleStringProperty((String) in.readObject());
        passord = new SimpleStringProperty((String) in.readObject());
    }
}

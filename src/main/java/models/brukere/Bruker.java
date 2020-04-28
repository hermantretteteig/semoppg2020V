package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

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
}

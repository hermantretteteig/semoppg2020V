package models;

public class Person {
    private String fornavn;
    private String etternavn;
    private String brukernavn;
    private String passord;

    public Person(String fornavn, String etternavn, String brukernavn, String passord) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.brukernavn = brukernavn;
        this.passord = passord;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}

package models.komponent;

import java.io.Serializable;

//Superklasse som alle andre varer arver fra.
public class Komponent implements Serializable {
    private static final long serialVersionUID = 1;

    private String modell;
    private double pris;
    private String varenr;
    private String varemerke;

    public Komponent(String modell, double pris, String varenr, String varemerke) {
        this.modell = modell;
        this.pris = pris;
        this.varenr = varenr;
        this.varemerke = varemerke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getVarenr() {
        return varenr;
    }

    public void setVarenr(String varenr) {
        this.varenr = varenr;
    }

    public String getVaremerke() {
        return varemerke;
    }

    public void setVaremerke(String varemerke) {
        this.varemerke = varemerke;
    }
}

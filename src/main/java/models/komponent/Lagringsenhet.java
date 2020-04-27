package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lagringsenhet extends Komponent{
    //Nedtreksliste med alle de ulike formatene (HDD, hybrid, SSD)
    private SimpleStringProperty format;
    private SimpleIntegerProperty gb;
    private SimpleStringProperty leseHastighet;
    private SimpleStringProperty skriveHastighet;

    public Lagringsenhet(String varenr, String varemerke, String modell, double pris, String format, int gb, String leseHastighet, String skriveHastighet) {
        super(varenr, varemerke, modell, pris);
        this.format = new SimpleStringProperty(format);
        this.gb = new SimpleIntegerProperty(gb);
        this.leseHastighet = new SimpleStringProperty(leseHastighet);
        this.skriveHastighet = new SimpleStringProperty(skriveHastighet);
    }


    public String getFormat() {
        return format.get();
    }

    public void setFormat(String format) {
        this.format = new SimpleStringProperty(format);
    }

    public int getGb() {
        return gb.get();
    }

    public void setGb(int gb) {
        this.gb = new SimpleIntegerProperty(gb);
    }

    public String getLeseHastighet() {
        return leseHastighet.get();
    }

    public void setLeseHastighet(String leseHastighet) {
        this.leseHastighet = new SimpleStringProperty(leseHastighet);
    }

    public String getSkriveHastighet() {
        return skriveHastighet.get();
    }

    public void setSkriveHastighet(String skriveHastighet) {
        this.skriveHastighet = new SimpleStringProperty(skriveHastighet);
    }

    @Override
    public String toString() {
        return "Lagringsenhet{" +
                "format='" + format + '\'' +
                ", gb=" + gb +
                ", leseHastighet='" + leseHastighet + '\'' +
                ", skriveHastighet='" + skriveHastighet + '\'' +
                '}';
    }
}

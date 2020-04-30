package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class HandlekurvVare {
    private SimpleStringProperty varenr;
    private SimpleStringProperty navn;
    private SimpleDoubleProperty pris;
    private SimpleStringProperty type;



    public HandlekurvVare(String varenr, String navn, Double pris, String type) {
        this.varenr = new SimpleStringProperty(varenr);
        this.navn = new SimpleStringProperty(navn);
        this.pris = new SimpleDoubleProperty(pris);
        this.type = new SimpleStringProperty(type);
    }

    public String getVarenr() {
        return varenr.get();
    }

    public SimpleStringProperty varenrProperty() {
        return varenr;
    }

    public void setVarenr(String varenr) {
        this.varenr.set(varenr);
    }

    public String getNavn() {
        return navn.get();
    }

    public SimpleStringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public double getPris() {
        return pris.get();
    }

    public SimpleDoubleProperty prisProperty() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris.set(pris);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}

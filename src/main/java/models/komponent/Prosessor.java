package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Prosessor extends Komponent {
    private SimpleIntegerProperty antallKjerner;
    private SimpleDoubleProperty klokkehastighet;

    public Prosessor(String varenr, String varemerke, String modell, double pris, int antallKjerner, double klokkehastighet) {
        super(varenr, varemerke, modell, pris);
        this.antallKjerner = new SimpleIntegerProperty(antallKjerner);
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
    }


    public int getAntallKjerner() {
        return antallKjerner.get();
    }

    public void setAntallKjerner(int antallKjerner) {
        this.antallKjerner = new SimpleIntegerProperty(antallKjerner);
    }

    public double getKlokkehastighet() {
        return klokkehastighet.get();
    }

    public void setKlokkehastighet(double klokkehastighet) {
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
    }

    @Override
    public String toString() {
        return "Prosessor{" +
                "antallKjerner=" + antallKjerner +
                ", klokkehastighet=" + klokkehastighet +
                '}';
    }
}

package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Skjermkort extends Komponent{
    private SimpleDoubleProperty klokkehastighet;
    private SimpleIntegerProperty minne;

    public Skjermkort(String varenr, String varemerke, String modell, int pris, double klokkehastighet, int minne) {
        super(varenr, varemerke, modell, pris);
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
        this.minne = new SimpleIntegerProperty(minne);
    }


    public double getKlokkehastighet() {
        return klokkehastighet.get();
    }

    public void setKlokkehastighet(double klokkehastighet) {
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
    }

    public int getMinne() {
        return minne.get();
    }

    public void setMinne(int minne) {
        this.minne = new SimpleIntegerProperty(minne);
    }

    @Override
    public String toString() {
        return "Skjermkort{" +
                "klokkehastighet=" + klokkehastighet +
                ", minne=" + minne +
                '}';
    }
}

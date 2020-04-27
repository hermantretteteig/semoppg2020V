package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Skjermkort extends Komponent{
    private transient SimpleDoubleProperty klokkehastighet;
    private transient SimpleIntegerProperty minne;

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

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(klokkehastighet.get());
        out.writeObject(minne.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        klokkehastighet = new SimpleDoubleProperty((Double) in.readObject());
        minne = new SimpleIntegerProperty((Integer) in.readObject());
    }
}

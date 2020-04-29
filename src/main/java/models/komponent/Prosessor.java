package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Prosessor extends Komponent {
    private transient SimpleIntegerProperty antallKjerner;
    private transient SimpleDoubleProperty klokkehastighet;

    //Konstruktør for opprettelse av nytt komponent.
    public Prosessor(String varemerke, String modell, double pris, int antallKjerner, double klokkehastighet) {
        super(varemerke, modell, pris);
        this.antallKjerner = new SimpleIntegerProperty(antallKjerner);
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
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

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(antallKjerner.get());
        out.writeObject(klokkehastighet.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        antallKjerner = new SimpleIntegerProperty((Integer) in.readObject());
        klokkehastighet = new SimpleDoubleProperty((Double) in.readObject());
    }
}

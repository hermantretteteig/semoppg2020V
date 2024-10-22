package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
Som alle andre komponenter arver klassen fra superkomponentobjektet.
 */


public class Skjermkort extends Komponent{
    private transient SimpleDoubleProperty klokkehastighet;
    private transient SimpleIntegerProperty minne;

    //Konstruktør for opprettelse av nytt komponent.
    public Skjermkort(String varemerke, String modell, double pris, double klokkehastighet, int minne) {
        super(varemerke, modell, pris);
        this.klokkehastighet = new SimpleDoubleProperty(klokkehastighet);
        this.minne = new SimpleIntegerProperty(minne);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Skjermkort(String varenr, String varemerke, String modell, double pris, double klokkehastighet, int minne) {
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

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Sørger for at, disse
    lagres som String/Integer/Double istedet.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(klokkehastighet.get());
        out.writeObject(minne.get());
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Konverterer
    String/Integer/Double til SimpleProperty når de leses fra fil.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        klokkehastighet = new SimpleDoubleProperty((Double) in.readObject());
        minne = new SimpleIntegerProperty((Integer) in.readObject());
    }
}

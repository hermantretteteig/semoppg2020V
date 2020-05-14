package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/*
Superklasse som alle de ulike komponentklassene arver fra.
 */

//ListerForFilbehandling som alle andre varer arver fra.
public class Komponent implements Serializable, Cloneable{
    private static final long serialVersionUID = 2;

    private transient SimpleStringProperty varenr;
    private transient SimpleStringProperty varemerke;
    private transient SimpleStringProperty modell;
    private transient SimpleDoubleProperty pris;

    //Konstruktør for opprettelse av nytt komponent.
    public Komponent(String varemerke, String modell, double pris) {
        this.varenr = new SimpleStringProperty(genererVarenr());
        this.varemerke = new SimpleStringProperty(varemerke);
        this.modell = new SimpleStringProperty(modell);
        this.pris = new SimpleDoubleProperty(pris);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Komponent(String varenr, String varemerke, String modell, double pris) {
        this.varenr = new SimpleStringProperty(varenr);
        this.varemerke = new SimpleStringProperty(varemerke);
        this.modell = new SimpleStringProperty(modell);
        this.pris = new SimpleDoubleProperty(pris);
    }

    /*
    Implementerer clone() metoden for å klone de ulike komponentene. Dette gjøres forå ungå at en ordre ikke endres
    etter utført kjøp, om f.eks prisen eller andre ting blir endret i etterkant.
     */
    public Komponent clone() throws CloneNotSupportedException {
        return (Komponent) super.clone();
    }

    public String getModell() {
        return modell.get();
    }

    //Simpel property get for treetable view
    public SimpleStringProperty getSSPVaremerke() {
        return varemerke;
    }

    //Metode som brukes av javaFX for å vise modellnavnet i viewet.
    public SimpleStringProperty getSSPModell() {
        return modell;
    }

    //Brukes for vise pris i viewet.
    public ObservableValue getSSPPris() {
        return pris;
    }

    public void setModell(String modell) {
        this.modell.set(modell);
    }

    public double getPris() {
        return pris.get();
    }

    public void setPris(double pris) {
        this.pris.set(pris);
    }

    public String getVarenr() {
        return varenr.get();
    }

    //Brukes i handlekurv for å vise merke og modell i samme kollonne
    public String getMerkeOgModell() {
        return varemerke.get()+" "+modell.get();
    }

    //Bruker i viewet
    public String getType() {
        return Komponent.super.getClass().getSimpleName();
    }

    public String getVaremerke() {
        return varemerke.get();
    }

    public void setVaremerke(String varemerke) {
        this.varemerke.set(varemerke);
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Sørger for at, disse
    lagres som String/Integer/Double istedet.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(varenr.get());
        out.writeObject(varemerke.get());
        out.writeObject(modell.get());
        out.writeObject(pris.get());
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Konverterer
    String/Integer/Double til SimpleProperty når de leses fra fil.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        varenr = new SimpleStringProperty((String) in.readObject());
        varemerke = new SimpleStringProperty((String) in.readObject());
        modell = new SimpleStringProperty((String) in.readObject());
        pris = new SimpleDoubleProperty((Double) in.readObject());
    }

    //Metode for generering av varenr
    private String genererVarenr() {
        UUID varenr = UUID.randomUUID();
        return varenr.toString();
    }

}

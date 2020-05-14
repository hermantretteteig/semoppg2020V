package models.komponent;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Som alle andre komponenter arver klassen fra superkomponentobjektet.
 */

public class Mus extends Komponent {
    private transient SimpleBooleanProperty trodlos;
    private transient SimpleStringProperty farge;

    //Konstruktør for opprettelse av ny komponent.
    public Mus(String varemerke, String modell, double pris, boolean trodlos, String farge) {
        super(varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.farge = new SimpleStringProperty(farge);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Mus(String varenr, String varemerke, String modell, double pris, boolean trodlos, String farge) {
        super(varenr, varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.farge = new SimpleStringProperty(farge);
    }

    public boolean getTrodlos() {
        return trodlos.get();
    }

    public void setTrodlos(boolean trodlos) {
        this.trodlos = new SimpleBooleanProperty(trodlos);
    }

    public String getFarge() {
        return farge.get();
    }

    public void setFarge(String farge) {
        this.farge = new SimpleStringProperty(farge);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(trodlos.get());
        out.writeObject(farge.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        trodlos = new SimpleBooleanProperty((Boolean) in.readObject());
        farge = new SimpleStringProperty((String) in.readObject());
    }

    public BooleanProperty getBpTrodlos() {
        return trodlos;
    }
}

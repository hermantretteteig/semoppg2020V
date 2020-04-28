package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//Superklasse som alle andre varer arver fra.
public class Komponent implements Serializable {
    private static final long serialVersionUID = 1;

    private transient SimpleStringProperty varenr;
    private transient SimpleStringProperty varemerke;
    private transient SimpleStringProperty modell;
    private transient SimpleDoubleProperty pris;

    public Komponent(String varenr, String varemerke, String modell, double pris) {
        this.varenr = new SimpleStringProperty(varenr);
        this.varemerke = new SimpleStringProperty(varemerke);
        this.modell = new SimpleStringProperty(modell);
        this.pris = new SimpleDoubleProperty(pris);

    }

    public String getModell() {
        return modell.get();
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

    public void setVarenr(String varenr) {
        this.varenr.set(varenr);
    }


    public String getVaremerke() {
        return varemerke.get();
    }

    public void setVaremerke(String varemerke) {
        this.varemerke.set(varemerke);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(varenr.get());
        out.writeObject(varemerke.get());
        out.writeObject(modell.get());
        out.writeObject(pris.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        varenr = new SimpleStringProperty((String) in.readObject());
        varemerke = new SimpleStringProperty((String) in.readObject());
        modell = new SimpleStringProperty((String) in.readObject());
        pris = new SimpleDoubleProperty((Double) in.readObject());
    }
}

package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mus extends Komponent {
    private transient SimpleBooleanProperty trodlos;
    private transient SimpleStringProperty farge;

    public Mus(String varenr, String varemerke, String modell, double pris, boolean trodlos, String farge) {
        super(varenr, varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.farge = new SimpleStringProperty(farge);
    }

    public boolean isTrodlos() {
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

    @Override
    public String toString() {
        return "Mus{" +
                "trodlos=" + trodlos +
                ", farge='" + farge + '\'' +
                '}';
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
}

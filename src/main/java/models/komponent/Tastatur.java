package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tastatur extends Komponent{
    private transient SimpleBooleanProperty  trodlos;
    private transient SimpleBooleanProperty  numpad;

    public Tastatur(String varenr, String varemerke, String modell, double pris, boolean trodlos, boolean numpad) {
        super(varenr, varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.numpad = new SimpleBooleanProperty (numpad);
    }


    public boolean getTrodlos() {
        return trodlos.get();
    }

    public void setTrodlos(boolean trodlos) {
        this.trodlos = new SimpleBooleanProperty(trodlos);
    }

    public boolean getNumpad() {
        return numpad.get();
    }

    public void setNumpad(boolean numpad) {
        this.numpad = new SimpleBooleanProperty(numpad);
    }

    @Override
    public String toString() {
        return "Tastatur{" +
                "trodlos=" + trodlos +
                ", numpad=" + numpad +
                '}';
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException {

        out.defaultWriteObject();
        out.writeObject(trodlos.get());
        out.writeObject(numpad.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        trodlos = new SimpleBooleanProperty((Boolean) in.readObject());
        numpad = new SimpleBooleanProperty((Boolean) in.readObject());
    }
}

package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tastatur extends Komponent{
    private SimpleBooleanProperty  trodlos;
    private SimpleBooleanProperty  numpad;

    public Tastatur(String varenr, String varemerke, String modell, double pris, boolean trodlos, boolean numpad) {
        super(varenr, varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.numpad = new SimpleBooleanProperty (numpad);
    }


    public boolean isTrodlos() {
        return trodlos.get();
    }

    public void setTrodlos(boolean trodlos) {
        this.trodlos = new SimpleBooleanProperty(trodlos);
    }

    public boolean isNumpad() {
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
}

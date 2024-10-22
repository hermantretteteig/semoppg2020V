package models.komponent;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Som alle andre komponenter arver klassen fra superkomponentobjektet.
 */


public class Tastatur extends Komponent{
    private transient SimpleBooleanProperty  trodlos;
    private transient SimpleBooleanProperty  numpad;

    //Konstruktør for opprettelse av nytt komponent.
    public Tastatur(String varemerke, String modell, double pris, boolean trodlos, boolean numpad) {
        super(varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.numpad = new SimpleBooleanProperty (numpad);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Tastatur(String varenr, String varemerke, String modell, double pris, boolean trodlos, boolean numpad) {
        super(varenr, varemerke, modell, pris);
        this.trodlos = new SimpleBooleanProperty(trodlos);
        this.numpad = new SimpleBooleanProperty (numpad);
    }

    public boolean getTrodlos() {
        return trodlos.get();
    }

    public void setTrodlos(boolean trodlos) {
        System.out.println("trådløs endring");
        this.trodlos = new SimpleBooleanProperty(trodlos);
    }

    public boolean getNumpad() {
        return numpad.get();
    }

    public BooleanProperty getBpTrodlos() {
        return trodlos;
    }

    public void setNumpad(boolean numpad) {
        this.numpad = new SimpleBooleanProperty(numpad);
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Sørger for at, disse
    lagres som String/Integer/Double istedet.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(trodlos.get());
        out.writeObject(numpad.get());
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleProperties, da det ikke støttes som standard. Konverterer
    String/Integer/Double til SimpleProperty når de leses fra fil.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        trodlos = new SimpleBooleanProperty((Boolean) in.readObject());
        numpad = new SimpleBooleanProperty((Boolean) in.readObject());
    }

    public BooleanProperty getBpNumpad() {
        return numpad;
    }
}

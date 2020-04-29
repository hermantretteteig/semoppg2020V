package models.komponent;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Skjerm extends Komponent {
    private transient SimpleIntegerProperty pixelBredde;
    private transient SimpleIntegerProperty pixelHoyde;

    //Automatisk generert av pixel høyde og bredde
    private transient SimpleBooleanProperty min4k;

    //Konstruktør for opprettelse av nytt komponent.
    public Skjerm(String varemerke, String modell, double pris, int pixelBredde, int pixelHoyde) {
        super(varemerke, modell, pris);
        this.pixelBredde = new SimpleIntegerProperty(pixelBredde);
        this.pixelHoyde = new SimpleIntegerProperty(pixelHoyde);
        this.min4k = new SimpleBooleanProperty(sjekk4K(pixelBredde, pixelHoyde));
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Skjerm(String varenr, String varemerke, String modell, double pris, int pixelBredde, int pixelHoyde, boolean min4k) {
        super(varenr, varemerke, modell, pris);
        this.pixelBredde = new SimpleIntegerProperty(pixelBredde);
        this.pixelHoyde = new SimpleIntegerProperty(pixelHoyde);
        this.min4k = new SimpleBooleanProperty(min4k);
    }

    public int getPixelBredde() {
        return pixelBredde.get();
    }

    public void setPixelBredde(int pixelBredde) {
        this.pixelBredde.set(pixelBredde);
        this.min4k.set(sjekk4K(pixelBredde, this.pixelHoyde.get()));
    }

    public int getPixelHoyde() {
        return pixelHoyde.get();
    }

    public void setPixelHoyde(int pixelHoyde) {
        this.pixelHoyde.set(pixelHoyde);
        this.min4k.set(sjekk4K(this.pixelBredde.get(), pixelHoyde));
    }

    public boolean getMin4K() {

        return min4k.get();
    }

    public void setMin4k(boolean min4k) {
        this.min4k = new SimpleBooleanProperty(min4k);
    }

    @Override
    public String toString() {
        return "Skjerm{" +
                "pixelBredde=" + pixelBredde +
                ", pixelHoyde=" + pixelHoyde +
                ", min4k=" + min4k +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(pixelBredde.get());
        out.writeObject(pixelHoyde.get());
        out.writeObject(min4k.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        pixelBredde = new SimpleIntegerProperty((Integer) in.readObject());
        pixelHoyde = new SimpleIntegerProperty((Integer) in.readObject());
        min4k = new SimpleBooleanProperty((Boolean) in.readObject());
    }

    private static boolean sjekk4K(int bredde, int hoyde) {
        if (bredde >= 3840 && hoyde >= 2160) {
            return true;
        } else {
            return false;
        }
    }

    public BooleanProperty getBpMin4K() {
        return min4k;
    }
}

package models.komponent;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Skjerm extends Komponent {
    private SimpleIntegerProperty pixelBredde;
    private SimpleIntegerProperty pixelHoyde;

    //Automatisk generert av pixel høyde og bredde
    private SimpleBooleanProperty min4k;

    public Skjerm(String varenr, String varemerke, String modell, double pris, int pixelBredde, int pixelHoyde) {
        super(varenr, varemerke, modell, pris);
        this.pixelBredde = new SimpleIntegerProperty(pixelBredde);
        this.pixelHoyde = new SimpleIntegerProperty(pixelHoyde);
        this.min4k = new SimpleBooleanProperty(sjekk4K(pixelBredde, pixelHoyde));
    }


    public int getPixelBredde() {
        return pixelBredde.get();
    }

    public void setPixelBredde(int pixelBredde) {
        this.pixelBredde = new SimpleIntegerProperty(pixelBredde);
        sjekk4K(pixelBredde, this.pixelHoyde.get());
    }

    public int getPixelHoyde() {
        return pixelHoyde.get();
    }

    public void setPixelHoyde(int pixelHoyde) {
        this.pixelHoyde = new SimpleIntegerProperty(pixelHoyde);
        sjekk4K(this.pixelBredde.get(), pixelHoyde);
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

    private static boolean sjekk4K(int bredde, int hoyde) {
        if (bredde >= 3840 || hoyde >= 2160) {
            return true;
        } else {
            return false;
        }
    }
}

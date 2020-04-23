package models.komponent;

public class Tastatur extends Komponent{
    private boolean trodlos;
    private boolean numpad;

    public Tastatur(String modell, double pris, String varenr, String varemerke, boolean trodlos, boolean numpad) {
        super(modell, pris, varenr, varemerke);
        this.trodlos = trodlos;
        this.numpad = numpad;
    }

    public boolean isTrodlos() {
        return trodlos;
    }

    public void setTrodlos(boolean trodlos) {
        this.trodlos = trodlos;
    }

    public boolean isNumpad() {
        return numpad;
    }

    public void setNumpad(boolean numpad) {
        this.numpad = numpad;
    }
}

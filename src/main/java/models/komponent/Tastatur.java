package models.komponent;

public class Tastatur extends Komponent{
    private boolean trodlos;
    private boolean numpad;

    public Tastatur(String varenr, String varemerke, String modell, double pris, boolean trodlos, boolean numpad) {
        super(varenr, varemerke, modell, pris);
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

    @Override
    public String toString() {
        return "Tastatur{" +
                "trodlos=" + trodlos +
                ", numpad=" + numpad +
                '}';
    }
}

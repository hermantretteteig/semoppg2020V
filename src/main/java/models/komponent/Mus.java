package models.komponent;

public class Mus extends Komponent {
    private boolean trodlos;
    private String farge;

    public Mus(String modell, double pris, String varenr, String varemerke, boolean trodlos, String farge) {
        super(modell, pris, varenr, varemerke);
        this.trodlos = trodlos;
        this.farge = farge;
    }

    public boolean isTrodlos() {
        return trodlos;
    }

    public void setTrodlos(boolean trodlos) {
        this.trodlos = trodlos;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}

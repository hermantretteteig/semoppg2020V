package models.komponent;

public class Mus extends Komponent {
    private boolean trodlos;
    private String farge;

    public Mus(String varenr, String varemerke, String modell, double pris, boolean trodlos, String farge) {
        super(varenr, varemerke, modell, pris);
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

    @Override
    public String toString() {
        return "Mus{" +
                "trodlos=" + trodlos +
                ", farge='" + farge + '\'' +
                '}';
    }
}

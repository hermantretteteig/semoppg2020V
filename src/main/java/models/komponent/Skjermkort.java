package models.komponent;

public class Skjermkort extends Komponent{
    private double klokkehastighet;
    private int minne;

    public Skjermkort(String modell, double pris, String varenr, String varemerke, double klokkehastighet, int minne) {
        super(modell, pris, varenr, varemerke);
        this.klokkehastighet = klokkehastighet;
        this.minne = minne;
    }

    public double getKlokkehastighet() {
        return klokkehastighet;
    }

    public void setKlokkehastighet(double klokkehastighet) {
        this.klokkehastighet = klokkehastighet;
    }

    public int getMinne() {
        return minne;
    }

    public void setMinne(int minne) {
        this.minne = minne;
    }

    @Override
    public String toString() {
        return "Skjermkort{" +
                "klokkehastighet=" + klokkehastighet +
                ", minne=" + minne +
                '}';
    }
}

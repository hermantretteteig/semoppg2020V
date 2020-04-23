package models.komponent;

public class Prosessor extends Komponent {
    private int antallKjerner;
    private double klokkehastighet;

    public Prosessor(String modell, double pris, String varenr, String varemerke, int antallKjerner, double klokkehastighet) {
        super(modell, pris, varenr, varemerke);
        this.antallKjerner = antallKjerner;
        this.klokkehastighet = klokkehastighet;
    }

    public int getAntallKjerner() {
        return antallKjerner;
    }

    public void setAntallKjerner(int antallKjerner) {
        this.antallKjerner = antallKjerner;
    }

    public double getKlokkehastighet() {
        return klokkehastighet;
    }

    public void setKlokkehastighet(double klokkehastighet) {
        this.klokkehastighet = klokkehastighet;
    }

    @Override
    public String toString() {
        return "Prosessor{" +
                "antallKjerner=" + antallKjerner +
                ", klokkehastighet=" + klokkehastighet +
                '}';
    }
}

package models.komponent;

public class Prosessor extends Komponent {
    private int antallKjerner;
    private double klokkehastighet;

    public Prosessor(String varenr, String varemerke, String modell, double pris, int antallKjerner, double klokkehastighet) {
        super(varenr, varemerke, modell, pris);
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

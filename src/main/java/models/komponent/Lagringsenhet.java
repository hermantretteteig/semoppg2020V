package models.komponent;

public class Lagringsenhet extends Komponent{
    //Nedtreksliste med alle de ulike formatene (HDD, hybrid, SSD)
    private String format;
    private int gb;
    private String leseHastighet;
    private String skriveHastighet;

    public Lagringsenhet(String varenr, String varemerke, String modell, double pris, String format, int gb, String leseHastighet, String skriveHastighet) {
        super(varenr, varemerke, modell, pris);
        this.format = format;
        this.gb = gb;
        this.leseHastighet = leseHastighet;
        this.skriveHastighet = skriveHastighet;
    }


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getLeseHastighet() {
        return leseHastighet;
    }

    public void setLeseHastighet(String leseHastighet) {
        this.leseHastighet = leseHastighet;
    }

    public String getSkriveHastighet() {
        return skriveHastighet;
    }

    public void setSkriveHastighet(String skriveHastighet) {
        this.skriveHastighet = skriveHastighet;
    }

    @Override
    public String toString() {
        return "Lagringsenhet{" +
                "format='" + format + '\'' +
                ", gb=" + gb +
                ", leseHastighet='" + leseHastighet + '\'' +
                ", skriveHastighet='" + skriveHastighet + '\'' +
                '}';
    }
}

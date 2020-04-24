package models.komponent;

public class Skjerm extends Komponent{
    private int pixelBredde;
    private int pixelHoyde;

    //Automatisk generert av pixel høyde og bredde
    private boolean min4k;

    public Skjerm(String varenr, String varemerke, String modell, double pris, int pixelBredde, int pixelHoyde, boolean min4k) {
        super(varenr, varemerke, modell, pris);
        this.pixelBredde = pixelBredde;
        this.pixelHoyde = pixelHoyde;
        this.min4k = min4k;
    }


    public int getPixelBredde() {
        return pixelBredde;
    }

    public void setPixelBredde(int pixelBredde) {
        this.pixelBredde = pixelBredde;
    }

    public int getPixelHoyde() {
        return pixelHoyde;
    }

    public void setPixelHoyde(int pixelHoyde) {
        this.pixelHoyde = pixelHoyde;
    }

    public boolean isMin4k() {
        return min4k;
    }

    public void setMin4k(boolean min4k) {
        this.min4k = min4k;
    }

    @Override
    public String toString() {
        return "Skjerm{" +
                "pixelBredde=" + pixelBredde +
                ", pixelHoyde=" + pixelHoyde +
                ", min4k=" + min4k +
                '}';
    }
}

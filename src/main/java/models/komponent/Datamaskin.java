package models.komponent;

public class Datamaskin{
    private Lagringsenhet lagringsenhet;
    private Skjerm skjerm;
    private Mus mus;
    private Prosessor prosessor;
    private Skjermkort skjermkort;
    private Tastatur tastatur;


    public Datamaskin(Lagringsenhet lagringsenhet, Skjerm skjerm, Mus mus, Prosessor prosessor, Skjermkort skjermkort, Tastatur tastatur) {
        this.lagringsenhet = lagringsenhet;
        this.skjerm = skjerm;
        this.mus = mus;
        this.prosessor = prosessor;
        this.skjermkort = skjermkort;
        this.tastatur = tastatur;
    }

    public Lagringsenhet getLagringsenhet() {
        return lagringsenhet;
    }

    public void setLagringsenhet(Lagringsenhet lagringsenhet) {
        this.lagringsenhet = lagringsenhet;
    }

    public Skjerm getSkjerm() {
        return skjerm;
    }

    public void setSkjerm(Skjerm skjerm) {
        this.skjerm = skjerm;
    }

    public Mus getMus() {
        return mus;
    }

    public void setMus(Mus mus) {
        this.mus = mus;
    }

    public Prosessor getProsessor() {
        return prosessor;
    }

    public void setProsessor(Prosessor prosessor) {
        this.prosessor = prosessor;
    }

    public Skjermkort getSkjermkort() {
        return skjermkort;
    }

    public void setSkjermkort(Skjermkort skjermkort) {
        this.skjermkort = skjermkort;
    }

    public Tastatur getTastatur() {
        return tastatur;
    }

    public void setTastatur(Tastatur tastatur) {
        this.tastatur = tastatur;
    }
}
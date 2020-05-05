package models.komponent;

import java.io.Serializable;

public class Datamaskin implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    private Lagringsenhet lagringsenhet;
    private Skjerm skjerm;
    private Mus mus;
    private Prosessor prosessor;
    private Skjermkort skjermkort;
    private Tastatur tastatur;


    public Datamaskin(Prosessor prosessor, Skjermkort skjermkort, Lagringsenhet lagringsenhet,  Skjerm skjerm, Mus mus, Tastatur tastatur) {
        this.prosessor = prosessor;
        this.skjermkort = skjermkort;
        this.lagringsenhet = lagringsenhet;
        this.skjerm = skjerm;
        this.mus = mus;
        this.tastatur = tastatur;
    }

    public Datamaskin clone() throws CloneNotSupportedException {
        Datamaskin datamaskin = (Datamaskin) super.clone();
        datamaskin.prosessor = (Prosessor) this.prosessor.clone();
        datamaskin.skjermkort = (Skjermkort) this.skjermkort.clone();
        datamaskin.lagringsenhet = (Lagringsenhet) this.lagringsenhet.clone();
        datamaskin.skjerm = (Skjerm) this.skjerm.clone();
        datamaskin.mus = (Mus) this.mus.clone();
        datamaskin.tastatur = (Tastatur) this.tastatur.clone();
        return datamaskin;
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

    /*@Override
    public String toString() {
        return "Datamaskin{" +
                "lagringsenhet=" + lagringsenhet +
                ", skjerm=" + skjerm +
                ", mus=" + mus +
                ", prosessor=" + prosessor +
                ", skjermkort=" + skjermkort +
                ", tastatur=" + tastatur +
                '}';
    }*/

}

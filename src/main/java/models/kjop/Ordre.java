package models.kjop;

import data.Eksempeldata;
import data.HandlekurvData;
import data.OrdeData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import models.brukere.Kunde;
import models.komponent.Datamaskin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ordre {
    private SimpleStringProperty ordrenumer;
    private SimpleStringProperty kjopsdato;
    private Kunde kunde;
    private SimpleDoubleProperty totalsum;
    private Datamaskin datamaskin;

    public Ordre(String ordrenumer, String kjopsdato, Kunde kunde, double totalsum, Datamaskin datamaskin) {
        this.ordrenumer = new SimpleStringProperty(ordrenumer);
        this.kjopsdato = new SimpleStringProperty(kjopsdato);
        this.kunde = kunde;
        this.totalsum = new SimpleDoubleProperty(totalsum);
        this.datamaskin = datamaskin;
    }

    public static void genererOrdre() {

        //TODO fikse ordrenummer for orde

        SimpleDateFormat naa = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dato = new Date();


        Ordre nyOrdre = new Ordre("1234", naa.format(dato), Eksempeldata.enKunde(), HandlekurvData.getSumHandlkurv(), HandlekurvData.genererDatamaskinAvHandlekurv());
        OrdeData.leggTilOrdre(nyOrdre);
        HandlekurvData.getHandekurv().clear();
    }

    public String getOrdrenumer() {
        return ordrenumer.get();
    }

    public SimpleStringProperty ordrenumerProperty() {
        return ordrenumer;
    }

    public void setOrdrenumer(String ordrenumer) {
        this.ordrenumer.set(ordrenumer);
    }

    public String getKjopsdato() {
        return kjopsdato.get();
    }

    public SimpleStringProperty kjopsdatoProperty() {
        return kjopsdato;
    }

    public void setKjopsdato(String kjopsdato) {
        this.kjopsdato.set(kjopsdato);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public double getTotalsum() {
        return totalsum.get();
    }

    public SimpleDoubleProperty totalsumProperty() {
        return totalsum;
    }

    public void setTotalsum(double totalsum) {
        this.totalsum.set(totalsum);
    }

    public Datamaskin getDatamaskin() {
        return datamaskin;
    }

    public void setDatamaskin(Datamaskin datamaskin) {
        this.datamaskin = datamaskin;
    }
}



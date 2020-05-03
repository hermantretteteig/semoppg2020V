package models.kjop;

import data.Eksempeldata;
import data.HandlekurvData;
import data.OrdreData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.chart.PieChart;
import models.brukere.Kunde;
import models.komponent.Datamaskin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Ordre {
    private SimpleStringProperty ordrenumer;
    private SimpleStringProperty kjopsdato;
    private Kunde kunde;
    private SimpleDoubleProperty totalsum;
    private Datamaskin datamaskin;

    public Ordre(String kjopsdato, Kunde kunde, Datamaskin datamaskin) {
        this.ordrenumer = new SimpleStringProperty(genererOrdrenr());
        this.kjopsdato = new SimpleStringProperty(kjopsdato);
        this.kunde = kunde;
        this.totalsum = new SimpleDoubleProperty(genererDatamaskinpris(datamaskin));
        this.datamaskin = datamaskin;
    }

    public double genererDatamaskinpris(Datamaskin enDatamaskin){
        return enDatamaskin.getLagringsenhet().getPris()+enDatamaskin.getMus().getPris()+
                enDatamaskin.getProsessor().getPris()+enDatamaskin.getSkjerm().getPris()+
                enDatamaskin.getSkjermkort().getPris()+enDatamaskin.getTastatur().getPris();

    }

    public static void genererOrdreAvHandlekurv() {
        SimpleDateFormat naa = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dato = new Date();

        Ordre nyOrdre = new Ordre(naa.format(dato), Eksempeldata.enKunde(), HandlekurvData.genererDatamaskinAvHandlekurv());
        OrdreData.leggTilOrdre(nyOrdre);
        HandlekurvData.getHandekurv().clear();

    }

    private static String genererOrdrenr() {
        UUID ordrenr = UUID.randomUUID();
        return ordrenr.toString();
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



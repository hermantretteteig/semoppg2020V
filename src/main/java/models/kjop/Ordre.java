package models.kjop;
import data.InnloggetBrukerData;
import data.HandlekurvData;
import data.OrdreData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import models.komponent.Datamaskin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
SimpleProperty brukes ettersom dette støttes av JavaFX tableview.
 */

public class Ordre implements Cloneable, Serializable{
    private static final long serialVersionUID = 1;

    private transient SimpleStringProperty ordrenumer;
    private transient SimpleStringProperty kjopsdato;
    private transient SimpleStringProperty kundenr;
    private transient SimpleDoubleProperty totalsum;
    private transient Datamaskin datamaskin;


    //Konstruktør for oppretting av nytt ordreobjekt.
    public Ordre(String kjopsdato, String kundenr, Datamaskin datamaskin) {
        this.ordrenumer = new SimpleStringProperty(genererOrdrenr());
        this.kjopsdato = new SimpleStringProperty(kjopsdato);
        this.kundenr = new SimpleStringProperty(kundenr);

         // - Finner totalprisen til ordren ved å kalle metoden "genrerDatamaskinpris".
         //   Denne metoden summerer prisene til komponentene  som er lagt til handlekurven

        this.totalsum = new SimpleDoubleProperty(genererDatamaskinpris(datamaskin));
        this.datamaskin = datamaskin;
    }
    //Konstruktør for henting av ordre fra fil.
    public Ordre(String ordrenumer, String kjopsdato, String kundenr, Double totalsum, Datamaskin datamaskin) {
        this.ordrenumer = new SimpleStringProperty(ordrenumer);
        this.kjopsdato = new SimpleStringProperty(kjopsdato);
        this.kundenr = new SimpleStringProperty(kundenr);
        this.totalsum = new SimpleDoubleProperty(totalsum);
        this.datamaskin = datamaskin;
    }

    //TODO hvor brukes denne egentlig?
    public Ordre Clone() throws CloneNotSupportedException {
        Ordre ordre = (Ordre) super.clone();
        ordre.datamaskin = (Datamaskin) this.datamaskin.clone();
        return ordre;
    }

    //Metode som brukes til kjøp. Metoden opprettet et nytt ordreobjekt ut av handlekurven.
    public static void genererOrdreAvHandlekurv() throws CloneNotSupportedException {
        //Bruker Date for å finne dato og tid akkurat nå
        SimpleDateFormat naa = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dato = new Date();

        /*
        Konstruktøren under gis følgende:
        - Setter tiden til ordren til "nå"
        - Finner kundenummeret til ordren ved å se hviklet kunde som er innloggget
        - Generer en datamaskin ut i fra komponentene som er lagt til i handlekureven
        */
        Ordre nyOrdre = new Ordre(
                naa.format(dato),
                InnloggetBrukerData.getInnloggetKunde().getKundenummer(),
                HandlekurvData.genererDatamaskinAvHandlekurv());

        //Legger til ordren i listen over ordre
        OrdreData.leggTilOrdre(nyOrdre);

        //Sletter handlekurven, slik at den er tom til neste kjøp.
        HandlekurvData.getHandlekurv().clear();
    }

    //Metodde som summerer prisen til alle komponentene som er generert i datamaskinen.
    private static double genererDatamaskinpris(Datamaskin enDatamaskin){
        return enDatamaskin.getLagringsenhet().getPris()+enDatamaskin.getMus().getPris()+
                enDatamaskin.getProsessor().getPris()+enDatamaskin.getSkjerm().getPris()+
                enDatamaskin.getSkjermkort().getPris()+enDatamaskin.getTastatur().getPris();

    }

    //Metoden som generer et unikt ordrenummer
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

    public String getKundenr() {
        return kundenr.get();
    }

    public void setKundnr(String kundenr) {
        this.kundenr.set(kundenr);
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(ordrenumer.get());
        out.writeObject(kjopsdato.get());
        out.writeObject(kundenr.get());
        out.writeObject(totalsum.get());
        out.writeObject(datamaskin);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        ordrenumer = new SimpleStringProperty((String) in.readObject());
        kjopsdato = new SimpleStringProperty((String) in.readObject());
        kundenr = new SimpleStringProperty((String) in.readObject());
        totalsum = new SimpleDoubleProperty((Double) in.readObject());
        datamaskin = (Datamaskin) in.readObject();
    }
}



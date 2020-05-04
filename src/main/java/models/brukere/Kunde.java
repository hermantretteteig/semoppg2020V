package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.util.UUID;

public class Kunde extends Bruker {
    private transient SimpleStringProperty kundenummer;
    private transient SimpleStringProperty epost;

    //Konstruktør for oppretting av ny kunde
    public Kunde(String fornavn, String etternavn, String brukernavn, String passord, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.kundenummer = new SimpleStringProperty(genererKundenr());
        this.epost = new SimpleStringProperty(epost);
    }

    //Konstruktør for oppretting av kunde fra eksempeldata
    public Kunde(String fornavn, String etternavn, String brukernavn, String passord, String kundenummer, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.kundenummer = new SimpleStringProperty(kundenummer);
        this.epost = new SimpleStringProperty(epost);
    }

    public String getKundenummer() {
        return kundenummer.get();
    }

    public void setKundenummer(String kundenummer) {

        this.kundenummer.set(kundenummer);
    }



    public String getEpost() {
        return epost.get();
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    private String genererKundenr() {
        UUID kundenr = UUID.randomUUID();
        return kundenr.toString();
    }
}

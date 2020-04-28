package models.brukere;

import javafx.beans.property.SimpleStringProperty;

public class Kunde extends Bruker {
    private transient SimpleStringProperty kundenummer;
    private transient SimpleStringProperty epost;

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
}

package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.util.UUID;

public class Admin extends Bruker {
    private transient SimpleStringProperty adminnummer;
    private transient SimpleStringProperty epost;

    //Konstruktør for oppretting av ny admin
    public Admin(String fornavn, String etternavn, String brukernavn, String passord, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.adminnummer = new SimpleStringProperty(genererAdminnr());
        this.epost = new SimpleStringProperty(epost);
    }

    //Konstruktør for oppretting av admin fra eksempeldata
    public Admin(String fornavn, String etternavn, String brukernavn, String passord, String kundenummer, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.adminnummer = new SimpleStringProperty(kundenummer);
        this.epost = new SimpleStringProperty(epost);
    }

    public Admin(String fornavn, String etternavn, String brukernavn, String passord) {
        super(fornavn, etternavn, brukernavn, passord);
    }

    public String getAdminnummer() {
        return adminnummer.get();
    }

    public void setAdminnummer(String adminnummer) {
        this.adminnummer.set(adminnummer);
    }

    public String getEpost() {
        return epost.get();
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    private String genererAdminnr() {
        UUID adminnr = UUID.randomUUID();
        return adminnr.toString();
    }
}

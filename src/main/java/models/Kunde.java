package models;

public class Kunde extends Person{
    private String kundenummer;
    private String epost;

    public Kunde(String fornavn, String etternavn, String brukernavn, String passord, String kundenummer, String epost) {
        super(fornavn, etternavn, brukernavn, passord);
        this.kundenummer = kundenummer;
        this.epost = epost;
    }

    public String getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(String kundenummer) {
        this.kundenummer = kundenummer;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}

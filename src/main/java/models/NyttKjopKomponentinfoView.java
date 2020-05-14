package models;

import javafx.beans.property.SimpleStringProperty;

/*
Klassen brukes for å vise detaljer om de ulike komponentene for kunden når han/hun skal foreta et kjøp. Klassen
består av to attributter. Den ene attributten (verdibeskrivelse) beskriver detaljen (f. eks. lagringskapasitet,
antall kjerner), mens den andre attributten (verdi) beskriver hviklen verdi detaljen har.
 */

public class NyttKjopKomponentinfoView {
    private SimpleStringProperty verdibeskrivelse;
    private SimpleStringProperty verdi;

    //Konstrutkør
    public NyttKjopKomponentinfoView(String verdibeskrivelse, String verdi) {
        this.verdibeskrivelse = new SimpleStringProperty(verdibeskrivelse);
        this.verdi = new SimpleStringProperty(verdi);
    }

    //Get-metode som brukes av FXML-filen i et tabellview.
    public String getVerdibeskrivelse() {
        return verdibeskrivelse.get();
    }

    //Get-metode som brukes av FXML-filen i et tabellview.
    public String getVerdi() {
        return verdi.get();
    }

    public SimpleStringProperty verdibeskrivelseProperty() {
        return verdibeskrivelse;
    }

    public void setVerdibeskrivelse(String verdibeskrivelse) {
        this.verdibeskrivelse.set(verdibeskrivelse);
    }

    public SimpleStringProperty verdiProperty() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi.set(verdi);
    }

}

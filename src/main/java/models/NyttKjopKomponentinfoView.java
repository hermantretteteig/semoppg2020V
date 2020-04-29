package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class NyttKjopKomponentinfoView {
    private SimpleStringProperty verdibeskrivelse;
    private SimpleStringProperty verdi;

    public NyttKjopKomponentinfoView(String verdibeskrivelse, String verdi) {
        this.verdibeskrivelse = new SimpleStringProperty(verdibeskrivelse);
        this.verdi = new SimpleStringProperty(verdi);
    }

    public String getVerdibeskrivelse() {
        return verdibeskrivelse.get();
    }

    public SimpleStringProperty verdibeskrivelseProperty() {
        return verdibeskrivelse;
    }

    public void setVerdibeskrivelse(String verdibeskrivelse) {
        this.verdibeskrivelse.set(verdibeskrivelse);
    }

    public String getVerdi() {
        return verdi.get();
    }

    public SimpleStringProperty verdiProperty() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi.set(verdi);
    }

}

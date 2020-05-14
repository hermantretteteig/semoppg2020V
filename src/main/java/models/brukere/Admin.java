package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class Admin extends Bruker {
    private transient SimpleStringProperty adminnummer;

    //Konstruktør for oppretting av ny admin
    public Admin(String fornavn, String etternavn, String brukernavn, String passord) {
        super(fornavn, etternavn, brukernavn, passord);
        this.adminnummer = new SimpleStringProperty(genererAdminnr());
    }

    //Konstruktør for oppretting av admin fra eksempeldata
    public Admin(String fornavn, String etternavn, String brukernavn, String passord, String adminnummer) {
        super(fornavn, etternavn, brukernavn, passord);
        this.adminnummer = new SimpleStringProperty(adminnummer);
    }

    public String getAdminnummer() {
        return adminnummer.get();
    }

    public void setAdminnummer(String adminnummer) {
        this.adminnummer.set(adminnummer);
    }

    private String genererAdminnr() {
        UUID adminnr = UUID.randomUUID();
        return adminnr.toString();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(adminnummer.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        adminnummer = new SimpleStringProperty((String) in.readObject());
    }
}

package models.brukere;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

/*
SimpleStringProperty blir brukt ettersom dette støttes direkte med tabelview fra JavaFX. Klassen
arver fra superklassen bruker.
 */

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

    //Generer et adminnummer ved bruk av UUID
    private String genererAdminnr() {
        return "ADMIN-" + UUID.randomUUID().toString();
    }


    /*
    Tilpasset metode for å kunne serialisere SimpleStringProperties, da det ikke støttes som standard. Sørger for at, disse
    lagres som String istedet.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(adminnummer.get());
    }

    /*
    Tilpasset metode for å kunne serialisere SimpleStringProperties, da det ikke støttes som standard. Konverterer
    String til SimpleStringProperty når de leses fra fil.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        adminnummer = new SimpleStringProperty((String) in.readObject());
    }
}

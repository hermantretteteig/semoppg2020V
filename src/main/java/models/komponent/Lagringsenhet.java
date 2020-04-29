package models.komponent;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lagringsenhet extends Komponent{
    //Nedtreksliste med alle de ulike formatene (HDD, hybrid, SSD)
    private transient SimpleStringProperty format;
    private transient SimpleIntegerProperty gb;
    private transient SimpleStringProperty leseHastighet;
    private transient SimpleStringProperty skriveHastighet;

    //Konstruktør for opprettelse av nytt komponent.
    public Lagringsenhet(String varemerke, String modell, double pris, String format, int gb, String leseHastighet, String skriveHastighet) {
        super(varemerke, modell, pris);
        this.format = new SimpleStringProperty(format);
        this.gb = new SimpleIntegerProperty(gb);
        this.leseHastighet = new SimpleStringProperty(leseHastighet);
        this.skriveHastighet = new SimpleStringProperty(skriveHastighet);
    }

    //Konstruktør for å opprette komponent fra tekstfil.
    public Lagringsenhet(String varenr, String varemerke, String modell, double pris, String format, int gb, String leseHastighet, String skriveHastighet) {
        super(varenr, varemerke, modell, pris);
        this.format = new SimpleStringProperty(format);
        this.gb = new SimpleIntegerProperty(gb);
        this.leseHastighet = new SimpleStringProperty(leseHastighet);
        this.skriveHastighet = new SimpleStringProperty(skriveHastighet);
    }


    public String getFormat() {
        return format.get();
    }

    public void setFormat(String format) {
        this.format.set(format);
    }

    public int getGb() {
        return gb.get();
    }

    public void setGb(int gb) {
        this.gb.set(gb);
    }

    public String getLeseHastighet() {
        return leseHastighet.get();
    }

    public void setLeseHastighet(String leseHastighet) {
        this.leseHastighet.set(leseHastighet);
    }

    public String getSkriveHastighet() {
        return skriveHastighet.get();
    }

    public void setSkriveHastighet(String skriveHastighet) {
        this.skriveHastighet.set(skriveHastighet);
    }

    @Override
    public String toString() {
        return "Lagringsenhet{" +
                "format='" + format + '\'' +
                ", gb=" + gb +
                ", leseHastighet='" + leseHastighet + '\'' +
                ", skriveHastighet='" + skriveHastighet + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(format.get());
        out.writeObject(gb.get());
        out.writeObject(leseHastighet.get());
        out.writeObject(skriveHastighet.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        format = new SimpleStringProperty((String) in.readObject());
        gb = new SimpleIntegerProperty((Integer) in.readObject());
        leseHastighet = new SimpleStringProperty((String) in.readObject());
        skriveHastighet = new SimpleStringProperty((String) in.readObject());
    }

    public StringProperty getSpFormat() {
        return this.format;
    }
}

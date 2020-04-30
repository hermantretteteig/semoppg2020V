package filbehandling;

import data.KomponentData;
import javafx.concurrent.Task;
import models.komponent.Komponent;

import java.util.ArrayList;

public class Traad extends Task<ArrayList<Komponent>> {
    private String filnavn;

    public Traad(String filnavn) {
        this.filnavn = filnavn;
    }


    @Override
    protected ArrayList<Komponent> call() throws InterruptedException {
        LesJOBJ lesFil = new LesJOBJ();
        try{
            Thread.sleep(5000);
            KomponentData.setAlleKomponenter(lesFil.lesKomponent(filnavn));
            //TODO feilhåndtering
        } catch (ClassNotFoundException e) {

        }

        return null;
    }
}

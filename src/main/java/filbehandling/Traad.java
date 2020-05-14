package filbehandling;

import data.AdminData;
import data.KomponentData;
import data.KundeData;
import data.OrdreData;
import javafx.collections.FXCollections;
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
        try{
            Thread.sleep(1000);
            ListerForFilbehandling listerForFilbehandling = LesJOBJ.lesListerForFilbehandling(filnavn);
            if(listerForFilbehandling != null) {
                listerForFilbehandling.setDataFraFil();
            }
            //TODO feilhåndtering
        } catch (ClassNotFoundException e) {

        }

        return null;
    }
}

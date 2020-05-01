package filbehandling;

import javafx.collections.ObservableList;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LagreJOBJ extends LagreFil {

    @Override
    public void lagreKomponent(ObservableList<Komponent> komponenter, String filnavn) {
        List<Komponent> liste = new ArrayList<>(komponenter);

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(liste);
        }
        //TODO Feilhåndtering
        catch (IOException e){

            //Kan også bruke den under istedenfor e.getCause-metoden
            //System.err.println("ERROR: Kan ikke lese filen fordi: "  + e.getCause());
            e.printStackTrace();
        }
    }

    @Override
    public void lagreDatamaskin(ObservableList<Datamaskin> datamaskiner, String filnavn) {
        List<Datamaskin> liste = new ArrayList<>(datamaskiner);

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {

            out.writeObject(liste);
        }
        //TODO Feilhåndtering
        catch (IOException e){
            System.err.println("ERROR: Kan ikke lese filen fordi: " + e.getCause());
            e.printStackTrace();
        }
    }
}


package filbehandling;

import javafx.collections.ObservableList;
import models.brukere.Bruker;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            e.printStackTrace();
        }
    }

    @Override
    public void lagreDatamaskin(ObservableList<Datamaskin> datamaskiner, String filnavn) {
        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(datamaskiner);
        }
        //TODO Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


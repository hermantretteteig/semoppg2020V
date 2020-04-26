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
    public void lagreBruker(Bruker bruker, String filnavn) {

    }

    @Override
    public void lagreKomponent(Komponent komponent, String filnavn) {

        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(komponent);
        }
        //Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void lagreKomponent(ObservableList<Komponent> komponenter, String filnavn) {
        List<Komponent> liste = new ArrayList<>(komponenter);

        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(liste);
        }
        //Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void lagreDatamaskin(Datamaskin datamaskin, String filnavn) {
        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(datamaskin);
        }
        //Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


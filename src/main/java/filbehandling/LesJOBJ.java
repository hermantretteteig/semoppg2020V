package filbehandling;

import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LesJOBJ extends LesFil {
    @Override
    public void lesDatamaskin(Path path) throws ClassNotFoundException {
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            Datamaskin datamaskin;
            datamaskin = (Datamaskin) object;
            System.out.println(datamaskin);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Komponent> lesKomponent(String filnavn) throws ClassNotFoundException {

        Path path = Paths.get(filnavn);
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            ArrayList<Komponent> komponenter;
            komponenter = (ArrayList<Komponent>) object;
            return komponenter;

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Todo fiks returverdi/ feilhåndtering
        return null;
    }
}

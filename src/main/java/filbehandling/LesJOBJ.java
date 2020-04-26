package filbehandling;

import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
    public List<Komponent> lesKomponent(String filnavn) throws ClassNotFoundException {

        Path path = Paths.get(filnavn);
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            List<Komponent> komponenter;
            komponenter = (List<Komponent>) object;
            for(Komponent enKomponent: komponenter){
                System.out.println(enKomponent);
            }
            return komponenter;

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Todo fiks returverdi
        return null;
    }
}

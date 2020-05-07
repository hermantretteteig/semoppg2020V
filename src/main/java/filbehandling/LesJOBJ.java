package filbehandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LesJOBJ {

    //Generisk metode for å hente ArrayLister med forskjellige typer, fra fil
    public static <T> ArrayList<T> lesListe(String filnavn) throws ClassNotFoundException {
        Path path = Paths.get(filnavn);
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            ArrayList<T> komponenter;
            komponenter = (ArrayList<T>) object;
            return komponenter;

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Todo fiks returverdi/ feilhåndtering
        return null;
    }
}

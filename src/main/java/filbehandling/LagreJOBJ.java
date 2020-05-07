package filbehandling;

import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LagreJOBJ {

    //Generisk metode for å lagre Observablelister med forskjellige typer, til fil
    public static <T, E> void lagreListe(ObservableList<T> enListe, String filnavn) {
        List<T> liste = new ArrayList<>(enListe);

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
}


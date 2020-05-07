package filbehandling;

import filbehandling.Parse.ParseKomponenterGammel;
import filbehandling.Parse.ParseOrdre;
import models.kjop.Ordre;
import models.komponent.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class LesCSV {

    public static ArrayList<Ordre> lesOrdre(String path) throws IOException{
        ArrayList<Ordre> ordreListe = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            reader.readLine();
            String linje;

            while ((linje = reader.readLine()) != null) {

                ordreListe.add(ParseOrdre.parseOrdre(linje));
            }
        }
        return ordreListe;
    }
}

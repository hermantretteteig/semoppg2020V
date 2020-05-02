package filbehandling;

import filbehandling.Parse.ParseKomponenter;
import models.komponent.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*private Lagringsenhet lagringsenhet;
private Skjerm skjerm;
private Mus mus;
private Prosessor prosessor;
private Skjermkort skjermkort;
private Tastatur tastatur;*/

public class LesCSV {
    public static Datamaskin lesDatamaskin(String path)throws IOException {
        Datamaskin datamaskin;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String linje;
            ArrayList<Komponent> komponenter = new ArrayList<>();


            while((linje = reader.readLine()) != null) {
                komponenter.add(ParseKomponenter.parseKomponent(linje));
            }
            datamaskin = new Datamaskin(
                    (Prosessor) komponenter.get(0),
                    (Skjermkort) komponenter.get(1),
                    (Lagringsenhet) komponenter.get(2),
                    (Skjerm) komponenter.get(3),
                    (Mus) komponenter.get(4),
                    (Tastatur) komponenter.get(5));
        }
        return datamaskin;
    }
}

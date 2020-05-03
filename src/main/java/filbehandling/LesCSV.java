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
                komponenter.add(ParseKomponenterGammel.parseKomponent(linje));
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

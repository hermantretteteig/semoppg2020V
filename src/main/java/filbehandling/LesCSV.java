package filbehandling;

import exceptions.InvalidBooleanFormatException;
import exceptions.InvalidNumberFormatException;
import exceptions.InvalidOrdreFormatException;
import filbehandling.Parse.ParseOrdre;
import models.kjop.Ordre;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class LesCSV {

    public static ArrayList<Ordre> lesOrdre(String path) throws IOException, InvalidOrdreFormatException, InvalidBooleanFormatException, InvalidNumberFormatException {
        ArrayList<Ordre> ordreListe = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            reader.readLine();
            String linje;

            while ((linje = reader.readLine()) != null) {

                ordreListe.add(ParseOrdre.parseOrdre(linje));
            }
        }
        return ordreListe;
    }
}

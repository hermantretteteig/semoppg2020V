package filbehandling;

import models.kjop.Ordre;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static filbehandling.Formatter.OrdreFormatter.formaterOrdre;

public class LagreCSV extends LagreFil {

    public void lagreOrdre(ArrayList<Ordre> ordre, String filnavn){
        try {
            Files.write(Paths.get(filnavn), formaterOrdre(ordre).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

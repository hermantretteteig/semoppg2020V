package filbehandling;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import models.brukere.Bruker;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LagreCSV extends LagreFil {

    @Override
    public void lagreKomponent(ObservableList<Komponent> komponenter, String filnavn) {

    }

    @Override
    public void lagreDatamaskin(ObservableList<Datamaskin> datamaskiner, String filnavn) {

    }

    public void lagreDatamaskin(Datamaskin datamaskin, String filnavn) throws IOException {
        Path path = Paths.get(filnavn);

        String ut = DatamaskinFormatter.formaterDatamaskin(datamaskin);

        try {
            Files.write(path, ut.getBytes());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        /*private Lagringsenhet lagringsenhet;
    private Skjerm skjerm;
    private Mus mus;
    private Prosessor prosessor;
    private Skjermkort skjermkort;
    private Tastatur tastatur;*/
}

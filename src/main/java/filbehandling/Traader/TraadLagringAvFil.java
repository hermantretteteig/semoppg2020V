package filbehandling.Traader;

import filbehandling.LagreJOBJ;
import filbehandling.ListerForFilbehandling;
import javafx.concurrent.Task;

import java.io.IOException;

public class TraadLagringAvFil extends Task<ListerForFilbehandling> {
    private String filnavn;

    public TraadLagringAvFil(String filnavn) {
        this.filnavn = filnavn;
    }


    @Override
    protected ListerForFilbehandling call() throws InterruptedException {
        try {
            Thread.sleep(4000);
            //Sjekker at lff objektet ikke er tomt, og lagrer til fil.
            ListerForFilbehandling lff = new ListerForFilbehandling();
            if (lff.getAdmins() != null && lff.getKunder() != null && lff.getOrdre() != null && lff.getKomponenter() != null) {
                LagreJOBJ.lagreListerForFilbehandling(lff, filnavn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

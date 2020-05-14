package filbehandling.Traader;

import filbehandling.LagreJOBJ;
import filbehandling.ListerForFilbehandling;
import javafx.concurrent.Task;

public class TraadLagringAvFil extends Task<ListerForFilbehandling> {
    private String filnavn;

    public TraadLagringAvFil(String filnavn) {
        this.filnavn = filnavn;
    }


    @Override
    protected ListerForFilbehandling call() throws InterruptedException {
        Thread.sleep(1000);
        //Sjekker at lff objektet ikke er tomt, og lagrer til fil.
        ListerForFilbehandling lff = new ListerForFilbehandling();
        if(lff != null) {
            LagreJOBJ.lagreListerForFilbehandling(lff, filnavn);
        }

        return null;
    }
}

package filbehandling.Traader;

import filbehandling.LesJOBJ;
import filbehandling.ListerForFilbehandling;
import javafx.concurrent.Task;

public class TraadHentingAvFil extends Task<ListerForFilbehandling> {
    private String filnavn;

    public TraadHentingAvFil(String filnavn) {
        this.filnavn = filnavn;
    }


    @Override
    protected ListerForFilbehandling call() throws InterruptedException {
        try{
            Thread.sleep(1000);
            //Henter ListerForFilBehandlings objekt fra fil, og sjekker att objektet ikke er tomt.
            ListerForFilbehandling lff = LesJOBJ.lesListerForFilbehandling(filnavn);
            if(lff != null)
            {
                lff.setDataFraFil();
            }
            //TODO feilhåndtering
        } catch (ClassNotFoundException e) {

        }

        return null;
    }
}

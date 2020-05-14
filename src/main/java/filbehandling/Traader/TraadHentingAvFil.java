package filbehandling.Traader;

import filbehandling.LesJOBJ;
import filbehandling.ListerForFilbehandling;
import javafx.concurrent.Task;

import java.io.IOException;

public class TraadHentingAvFil extends Task<ListerForFilbehandling> {
    private String filnavn;

    public TraadHentingAvFil(String filnavn) {
        this.filnavn = filnavn;
    }


    @Override
    protected ListerForFilbehandling call() throws InterruptedException {
        try{
            Thread.sleep(1000);
            //Henter ListerForFilBehandlingsobjekt fra fil, og sjekker att objektet ikke er tomt.
            ListerForFilbehandling lff = LesJOBJ.lesListerForFilbehandling(filnavn);
            if(lff.getAdmins() != null && lff.getKunder() != null && lff.getOrdre() != null && lff.getKomponenter() != null)
            {
                lff.setDataFraFil();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package data;

import models.brukere.Admin;
import models.brukere.Kunde;

public class InnloggetBrukerData {
    /*Når brukeren" er logget inn settes han/hun lik "innloggetKunde"/"innloggetAdmin", slik at dataene
    til kunden kan akselreres fra ulike steder i programvaren*/
    private static Kunde innloggetKunde = null;
    private static Admin innloggetAdmin = null;

    //Logger ut ved å sette innlogget kunde til null
    public static void loggUtKunde(){
        innloggetKunde = null;
    }

    //Logger ut ved å sette innlogget admin til null
    public static void loggUtAdmin(){
        innloggetAdmin = null;
    }

    public static boolean loggInnKunde(String brukernavn, String passord){
        //Sjekker om kunden er registrert i listen, ved å kontrollere at brukernavn eksitrerer
        // og tilhørende passord er riktig.
        for(Kunde enKunde : KundeData.getKunder()){
            if(enKunde.getPassord().equals(passord) && enKunde.getBrukernavn().equals(brukernavn)){
                innloggetKunde = enKunde;
                return true;
            }
        }
        return false;
    }

    public static boolean loggInnAdmin(String brukernavn, String passord){
        //Sjekker om administratoren er registrert i listen, ved å kontrollere at brukernavn eksitrerer
        // og tilhørende passord er riktig.
        for(Admin enAdmin : AdminData.getAdmins()){
            if(enAdmin.getPassord().equals(passord)&&enAdmin.getBrukernavn().equals(brukernavn)){
                innloggetAdmin = enAdmin;
                return true;
            }
        }
        return false;
    }

    public static Kunde getInnloggetKunde() {
        return innloggetKunde;
    }

    public static Admin getInnloggetAdmn() {
        return innloggetAdmin;
    }

}



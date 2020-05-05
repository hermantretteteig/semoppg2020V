package eksempeldata;

import data.*;
import filbehandling.Formatter.DatamaskinFormatter;
import filbehandling.Formatter.OrdreFormatter;
import models.brukere.Admin;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.*;

import java.util.Formatter;

public class Eksempeldata {

    //Skal fjernes
    public static Kunde enKunde(){
        return new Kunde("Ole", "Hansen", "olehasen", "hemmelig", "ole.hansen@online.no");
    }

    public static void GenererEksempeldata() throws CloneNotSupportedException {

        Kunde nyKunde1 = new Kunde("Ole", "Hansen", "olehansen", "passord123", "eksempelKunde1",  "ole.hansen@online.no");
        Kunde nyKunde2 = new Kunde("Stian", "Ludviksen", "stianlud", "hemmelig", "eksempelKunde2", "stian.lud@online.no");
        KundeData.getKunder().addAll(nyKunde1, nyKunde2);

        Admin nyAdmin = new Admin("Adim", "Amid", "admin", "passord123");
        AdminData.leggTilAdmin(nyAdmin);

        Lagringsenhet lagringsenhetEn = new Lagringsenhet(
                "Samsung",
                "2000",
                2490,
                "SSD",
                512,
                "1250",
                "2150");

        Lagringsenhet lagringsenhetTo = new Lagringsenhet(
                "Apple",
                "Ultra",
                9490,
                "SSD",
                512,
                "2456",
                "2134");

        Mus musEn = new Mus(
                "Logi",
                "Super",
                499,
                true,
                "#F2F2F2");

        Mus toMus = new Mus(
                "Apple",
                "Rask",
                699,
                true,
                "#000000");

        Prosessor prosessor1 = new Prosessor(
                "AMD",
                "i5",
                4599,
                12,
                1200);

        Prosessor prosessor2 = new Prosessor(
                "Intel",
                "i7",
                6099,
                12,
                2400);

        Skjerm skjerm1 = new Skjerm(
                "LG",
                "MH56",
                1499,
                1280,
                720);

        Skjerm skjerm2 = new Skjerm(
                "LG",
                "Ultra 4K",
                5499,
                3840,
                2160);

        Skjermkort skjermkort1 = new Skjermkort(
                "GTX",
                "Lyn",
                5499,
                1245,
                2);

        Skjermkort skjermkort2 = new Skjermkort(
                "GTX",
                "Pro",
                8499,
                2245,
                3);

        Tastatur tastatur1 = new Tastatur(
                "Logo",
                "Ultra",
                1499,
                true,
                true);

        Tastatur tastatur2 = new Tastatur(
                "Logi",
                "Simpel",
                499,
                false,
                false);

        //Legger alle komponenete til i lista
        KomponentData.getAlleKomponenter().addAll(
                lagringsenhetEn,
                lagringsenhetTo,
                musEn,
                toMus,
                prosessor1,
                prosessor2,
                skjerm1,
                skjerm2,
                skjermkort1,
                skjermkort2,
                tastatur1,
                tastatur2);

        Datamaskin nyDatamaskin1 = new Datamaskin(prosessor1, skjermkort2, lagringsenhetEn, skjerm1, toMus, tastatur1);
        Datamaskin nyDatamaskin2 = new Datamaskin(prosessor2, skjermkort1, lagringsenhetTo, skjerm1, musEn, tastatur2);

        Ordre nyOrdre1 = new Ordre("12/02/2017 13:21:00", nyKunde1.getKundenummer(), nyDatamaskin1);
        Ordre nyOrdre2 = new Ordre("03/11/2019 22:03:03", nyKunde2.getKundenummer(), nyDatamaskin2);
        //Her ser du hvordan du kloner. Kan også gjøres med datamaskin eller komponent.
        Ordre nyOrdre3 = nyOrdre1.Clone();


        ValgtOrdreSinDatamaskinData.leggTil(lagringsenhetEn);


        OrdreData.leggTilOrdre(nyOrdre1);
        OrdreData.leggTilOrdre(nyOrdre2);

        String ut1 = OrdreFormatter.formaterOrdre2(nyOrdre1);
        String ut2 = OrdreFormatter.formaterOrdre2(nyOrdre3);

        System.out.println(ut1);
        System.out.println();
        System.out.println(ut2);

        System.out.println();
        System.out.println(nyOrdre1);
        System.out.println(nyOrdre3);

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin());
        System.out.println(nyOrdre3.getDatamaskin());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getProsessor());
        System.out.println(nyOrdre3.getDatamaskin().getProsessor());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getSkjermkort());
        System.out.println(nyOrdre3.getDatamaskin().getSkjermkort());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getLagringsenhet());
        System.out.println(nyOrdre3.getDatamaskin().getLagringsenhet());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getSkjerm());
        System.out.println(nyOrdre3.getDatamaskin().getSkjerm());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getMus());
        System.out.println(nyOrdre3.getDatamaskin().getMus());

        System.out.println();
        System.out.println(nyOrdre1.getDatamaskin().getTastatur());
        System.out.println(nyOrdre3.getDatamaskin().getTastatur());

        }
}

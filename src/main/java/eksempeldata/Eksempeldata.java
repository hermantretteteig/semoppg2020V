package eksempeldata;

import data.*;
import models.brukere.Admin;
import models.brukere.Kunde;
import models.kjop.Ordre;
import models.komponent.*;

/*
Denne filen genrerer eksempeldata som gjør det enklere å illustrere funksjonaliteten til programmet.
 */

public class Eksempeldata {

    //TODO Skal fjernes
    public static Kunde enKunde(){
        return new Kunde("Ole", "Hansen", "olehasen", "hemmelig", "ole.hansen@online.no");
    }

    public static void GenererEksempeldata() {

        Kunde nyKunde1 = new Kunde("Ole", "Hansen", "olehansen", "passord123", "edf60e08-9b08-442c-b07d-b6bf2bb7670d",  "ole.hansen@online.no");
        Kunde nyKunde2 = new Kunde("Stian", "Ludviksen", "stianlud", "hemmelig", "d393e84c-0dd3-401c-a63e-5895eaef0b00", "stian.lud@hotmail.com");
        Kunde nyKunde3 = new Kunde("Entotre", "Firefemseks", "123", "123", "8ef47a17-380f-4707-af18-da38d238ae8c", "123entotre@live.com");
        Kunde nyKunde4 = new Kunde("Kunde", "Kundesen", "KundeKundesen", "Kundser345", "34d29c9e-8d8e-40b3-a68c-9921c8647e07", "kunde@kundesen.no");
        Kunde nyKunde5 = new Kunde("Morten", "Hansen", "mortenhansen", "Passord45", "ba784046-e4fe-4fdf-ab7e-638674630f72", "mortenhansen@gmail.com");
        Kunde nyKunde6 = new Kunde("Oliver", "Hansen", "oliverhansen", "OliHans90", "22e91143-3cd4-4a45-a92e-a5ddbd33c220", "oliver.hansen@online.no");
        KundeData.getKunder().addAll(nyKunde1, nyKunde2, nyKunde3, nyKunde4, nyKunde5, nyKunde6);

        //TODO må fjernes før levering
        InnloggetBrukerData.loggInnKunde("olehansen", "passord123");

        Admin nyAdmin = new Admin("Adim", "Amid", "admin", "passord123", "edf60e08-9b08-442c-b07d-b6bf2bb7670c");
        AdminData.leggTilAdmin(nyAdmin);

        Lagringsenhet lagringsenhetEn = new Lagringsenhet(
                "Samsung",
                "2000",
                2490,
                "SSD 2.5",
                512,
                "1250",
                "2150");

        Lagringsenhet lagringsenhetTo = new Lagringsenhet(
                "Apple",
                "Ultra",
                9490,
                "SSD 2.5",
                512,
                "2456",
                "2134");

        Mus musEn = new Mus(
                "Logi",
                "Super",
                499,
                true,
                "Svart");

        Mus toMus = new Mus(
                "Apple",
                "Rask",
                699,
                true,
                "Hvit");

        Prosessor prosessor1 = new Prosessor(
                "Intel",
                "i5",
                4599,
                8,
                2.3);

        Prosessor prosessor2 = new Prosessor(
                "Intel",
                "i7",
                6099,
                12,
                3.2);

        Skjerm skjerm1 = new Skjerm(
                "LG",
                "MH56",
                1499,
                1280,
                720);

        Skjerm skjerm2 = new Skjerm(
                "Acer",
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



        Lagringsenhet lagringsenhet3 = new Lagringsenhet(
                "Samsung",
                "2000",
                2490,
                "SSD 2.5",
                254,
                "895",
                "560");

        Lagringsenhet lagringsenhet4 = new Lagringsenhet(
                "Apple",
                "Ultra",
                1049,
                "HDD",
                1028,
                "180",
                "120");

        Mus mus3 = new Mus(
                "Microsoft",
                "Arc",
                599,
                true,
                "Brun");

        Mus mus4 = new Mus(
                "Asus",
                "Rog",
                1390,
                false,
                "Rød");

        Prosessor prosessor3 = new Prosessor(
                "Intel",
                "i9",
                7599,
                12,
                3.6);

        Prosessor prosessor4 = new Prosessor(
                "Intel",
                "i3",
                2490,
                4,
                2.4);

        Skjerm skjerm3 = new Skjerm(
                "LG",
                "DG CURVED-55",
                9490,
                3440,
                1440);

        Skjerm skjerm4 = new Skjerm(
                "AOC",
                "Simpel 22",
                2560,
                1920,
                1080);

        Skjermkort skjermkort3 = new Skjermkort(
                "ZOTAC",
                "GeForce RTX 2080",
                10390,
                1815,
                8);

        Skjermkort skjermkort4 = new Skjermkort(
                "ASUS",
                "GTX 650",
                2450,
                1100,
                4);

        Tastatur tastatur3 = new Tastatur(
                "Plexgear",
                "T9",
                399,
                true,
                false);

        Tastatur tastatur4 = new Tastatur(
                "Microsoft",
                "Prokey",
                1799,
                true,
                true);


        //Legger alle komponenete til i lista
        KomponentData.getKomponenter().addAll(
                lagringsenhetEn,
                lagringsenhetTo,
                lagringsenhet3,
                lagringsenhet4,
                musEn,
                toMus,
                mus3,
                mus4,
                prosessor1,
                prosessor2,
                prosessor3,
                prosessor4,
                skjerm1,
                skjerm2,
                skjerm3,
                skjerm4,
                skjermkort1,
                skjermkort2,
                skjermkort3,
                skjermkort4,
                tastatur1,
                tastatur2,
                tastatur3,
                tastatur4);

        Datamaskin nyDatamaskin1 = new Datamaskin(prosessor1, skjermkort2, lagringsenhetEn, skjerm1, toMus, tastatur1);
        Datamaskin nyDatamaskin2 = new Datamaskin(prosessor2, skjermkort1, lagringsenhetTo, skjerm1, musEn, tastatur2);
        Datamaskin nyDatamaskin3 = new Datamaskin(prosessor4, skjermkort4, lagringsenhetEn, skjerm1, mus3, tastatur2);
        Datamaskin nyDatamaskin4 = new Datamaskin(prosessor1, skjermkort4, lagringsenhet3, skjerm2, toMus, tastatur4);
        Datamaskin nyDatamaskin5 = new Datamaskin(prosessor2, skjermkort3, lagringsenhetTo, skjerm2, mus4, tastatur1);
        Datamaskin nyDatamaskin6 = new Datamaskin(prosessor3, skjermkort1, lagringsenhetEn, skjerm1, mus3, tastatur1);
        Datamaskin nyDatamaskin7 = new Datamaskin(prosessor2, skjermkort2, lagringsenhetTo, skjerm4, musEn, tastatur3);
        Datamaskin nyDatamaskin8 = new Datamaskin(prosessor2, skjermkort3, lagringsenhet4, skjerm4, musEn, tastatur3);
        Datamaskin nyDatamaskin9 = new Datamaskin(prosessor3, skjermkort4, lagringsenhetEn, skjerm3, mus4, tastatur2);
        Datamaskin nyDatamaskin10 = new Datamaskin(prosessor4, skjermkort2, lagringsenhet4, skjerm3, mus4, tastatur2);
        Datamaskin nyDatamaskin11 = new Datamaskin(prosessor4, skjermkort1, lagringsenhet4, skjerm1, musEn, tastatur2);
        Datamaskin nyDatamaskin12 = new Datamaskin(prosessor3, skjermkort3, lagringsenhet3, skjerm1, mus3, tastatur3);
        Datamaskin nyDatamaskin13 = new Datamaskin(prosessor4, skjermkort3, lagringsenhetTo, skjerm4, mus3, tastatur1);
        Datamaskin nyDatamaskin14 = new Datamaskin(prosessor1, skjermkort1, lagringsenhet3, skjerm1, toMus, tastatur4);
        Datamaskin nyDatamaskin15 = new Datamaskin(prosessor1, skjermkort2, lagringsenhetTo, skjerm4, mus4, tastatur3);
        Datamaskin nyDatamaskin16 = new Datamaskin(prosessor4, skjermkort2, lagringsenhetEn, skjerm1, toMus, tastatur1);
        Datamaskin nyDatamaskin17 = new Datamaskin(prosessor3, skjermkort4, lagringsenhet4, skjerm1, mus4, tastatur3);

        Ordre nyOrdre1 = new Ordre("23/02/2017 13:39:12", nyKunde1.getKundenummer(), nyDatamaskin1);
        Ordre nyOrdre2 = new Ordre("22/11/2015 12:28:34", nyKunde2.getKundenummer(), nyDatamaskin2);
        Ordre nyOrdre3 = new Ordre("12/04/2020 14:23:27", nyKunde3.getKundenummer(), nyDatamaskin3);
        Ordre nyOrdre4 = new Ordre("02/01/2020 10:34:38", nyKunde4.getKundenummer(), nyDatamaskin4);
        Ordre nyOrdre5 = new Ordre("04/03/2019 07:12:32", nyKunde1.getKundenummer(), nyDatamaskin5);
        Ordre nyOrdre6 = new Ordre("12-10-2016", nyKunde2.getKundenummer(), nyDatamaskin6);
        Ordre nyOrdre7 = new Ordre("25-11-2018", nyKunde3.getKundenummer(), nyDatamaskin7);
        Ordre nyOrdre8 = new Ordre("12-12-2018", nyKunde4.getKundenummer(), nyDatamaskin8);
        Ordre nyOrdre9 = new Ordre("28-10-2020", nyKunde1.getKundenummer(), nyDatamaskin9);
        Ordre nyOrdre10 = new Ordre("12/03/2020 15:43:44", nyKunde2.getKundenummer(), nyDatamaskin10);
        Ordre nyOrdre11 = new Ordre("30/08/2012 18:34:25", nyKunde5.getKundenummer(), nyDatamaskin11);
        Ordre nyOrdre12 = new Ordre("18/09/2017 23:45:32", nyKunde6.getKundenummer(), nyDatamaskin12);
        Ordre nyOrdre13 = new Ordre("13/10/2018 20:23:43", nyKunde1.getKundenummer(), nyDatamaskin13);
        Ordre nyOrdre14 = new Ordre("12/06/2019 19:54:23", nyKunde5.getKundenummer(), nyDatamaskin14);
        Ordre nyOrdre15 = new Ordre("19/02/2020 14:23:43", nyKunde1.getKundenummer(), nyDatamaskin15);
        Ordre nyOrdre16 = new Ordre("15/03/2017 10:44:45", nyKunde3.getKundenummer(), nyDatamaskin16);
        Ordre nyOrdre17 = new Ordre("25/07/2016 17:23:10", nyKunde6.getKundenummer(), nyDatamaskin17);

        OrdreData.leggTilOrdre(nyOrdre1);
        OrdreData.leggTilOrdre(nyOrdre2);
        OrdreData.leggTilOrdre(nyOrdre3);
        OrdreData.leggTilOrdre(nyOrdre4);
        OrdreData.leggTilOrdre(nyOrdre5);
        OrdreData.leggTilOrdre(nyOrdre6);
        OrdreData.leggTilOrdre(nyOrdre7);
        OrdreData.leggTilOrdre(nyOrdre8);
        OrdreData.leggTilOrdre(nyOrdre9);
        OrdreData.leggTilOrdre(nyOrdre10);
        OrdreData.leggTilOrdre(nyOrdre11);
        OrdreData.leggTilOrdre(nyOrdre12);
        OrdreData.leggTilOrdre(nyOrdre13);
        OrdreData.leggTilOrdre(nyOrdre14);
        OrdreData.leggTilOrdre(nyOrdre15);
        OrdreData.leggTilOrdre(nyOrdre16);
        OrdreData.leggTilOrdre(nyOrdre17);
        }
}

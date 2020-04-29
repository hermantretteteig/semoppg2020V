package data;

import models.komponent.*;

public class Eksempeldata {

    public static void GenererEksempeldata(){
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

        for(Komponent enKomponent : KomponentData.getAlleKomponenter()){
            System.out.println("Pris: "+enKomponent.getPris()+"\nVarenr: "+
                    enKomponent.getVarenr()+"\nModell: "+enKomponent.getModell()+"\nVaremerke: "+enKomponent.getVaremerke()+"\n\n");

        }
        }
}

package models.Tore;

import models.komponent.*;
import filbehandling.LagreJOBJ;
import filbehandling.LesJOBJ;

import java.io.File;
import java.util.UUID;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //Lagringsenhet  lagringsenhet = new Lagringsenhet("Samsung", 1000, "1234", "evo8000", "SSD", 500, "1000", "3000");
        //Mus mus = new Mus("Logitech", 300, "1232", "G5", true, "Svart");
        //Prosessor prosessor = new Prosessor("Intel", 1500, "1222","Pentium", 4, 2.6);
        //Skjerm skjerm = new Skjerm("Samsung", 2200, "1222", "Godskjermen", 1980, 1024, false);
        /*Skjermkort skjermkort = new Skjermkort("1111", "MSI", "nVidia1080", 2800, 2, 6);
        //Tastatur tastatur = new Tastatur("Logitech", 150, "1010", "G78", false, true);

        //Datamaskin datamaskin = new Datamaskin(lagringsenhet, mus, prosessor, skjerm, skjermkort, tastatur);



        LagreJOBJ lagre = new LagreJOBJ();
        //lagre.lagreKomponent(skjermkort, "nvidia.jobj");
        //lagre.lagreDatamaskin(datamaskin, "datamaskin1.jobj");

        LesJOBJ les = new LesJOBJ();
        //Path path = Paths.get("datamaskin1.jobj");

        //Path path2 = Paths.get("nvidia.jobj");
        //les.lesKomponent(path2);

        try {

            // Create a file object
            File f = new File("program.txt");

            // Get the absolute path of file f
            String absolute = f.getAbsolutePath();

            // Display the file path of the file object
            // and also the file path of absolute file
            System.out.println("Original  path: "
                    + f.getPath());
            String path = absolute;
            System.out.println("Absolute  path: "
                    + absolute);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }*/

            UUID varenr = UUID.randomUUID();
            System.out.println(varenr.toString());
    }
}

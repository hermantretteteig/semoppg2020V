package models.Tore;

import models.komponent.*;
import org.example.filbehandling.LagreJOBJ;
import org.example.filbehandling.LesJOBJ;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Lagringsenhet  lagringsenhet = new Lagringsenhet("Samsung", 1000, "1234", "evo8000", "SSD", 500, "1000", "3000");
        Mus mus = new Mus("Logitech", 300, "1232", "G5", true, "Svart");
        Prosessor prosessor = new Prosessor("Intel", 1500, "1222","Pentium", 4, 2.6);
        Skjerm skjerm = new Skjerm("Samsung", 2200, "1222", "Godskjermen", 1980, 1024, false);
        Skjermkort skjermkort = new Skjermkort("MSI", 2800, "1111", "nVidia 1070gtx", 2, 6);
        Tastatur tastatur = new Tastatur("Logitech", 150, "1010", "G78", false, true);

        Datamaskin datamaskin = new Datamaskin(lagringsenhet, mus, prosessor, skjerm, skjermkort, tastatur);

        LagreJOBJ lagre = new LagreJOBJ();
        lagre.lagreDatamaskin(datamaskin, "datamaskin1.jobj");

        LesJOBJ les = new LesJOBJ();
        Path path = Paths.get("datamaskin1.jobj");
        les.lesDatamaskin(path);
    }
}

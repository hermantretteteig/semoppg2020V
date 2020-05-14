package filbehandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LesJOBJ {

    //Metode for å hente fra fil
    public static ListerForFilbehandling lesListerForFilbehandling(String filnavn) throws ClassNotFoundException, IOException {
        Path path = Paths.get(filnavn);
        InputStream in = Files.newInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(in);
        Object object = oin.readObject();
        ListerForFilbehandling lff = (ListerForFilbehandling) object;
        return lff;
    }
}

package filbehandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LagreJOBJ {

    public static void lagreListerForFilbehandling(ListerForFilbehandling listerForFilbehandling, String filnavn) throws IOException {

        FileOutputStream fos = new FileOutputStream(filnavn);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(listerForFilbehandling);
    }
}


package org.example.filbehandling;

import models.Person;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LagreJOBJ extends LagreFil {
    @Override
    public void lagreBruker(Person person) {

    }

    @Override
    public void lagreKomponent(Komponent komponent) {

    }

    @Override
    public void lagreDatamaskin(Datamaskin datamaskin, String filnavn) {
        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(datamaskin);
        }
        //Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


package org.example.filbehandling;

import models.brukere.Bruker;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LagreJOBJ extends LagreFil {


    @Override
    public void lagreBruker(Bruker bruker, String filnavn) {

    }

    @Override
    public void lagreKomponent(Komponent komponent, String filnavn) {

        LagreFil lagre = new LagreJOBJ();
        LesFil les = new LesJOBJ();

        try(FileOutputStream fos = new FileOutputStream(filnavn);
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(komponent);
        }
        //Feilhåndtering
        catch (IOException e){
            e.printStackTrace();
        }
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


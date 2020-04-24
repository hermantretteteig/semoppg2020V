package org.example.filbehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import models.komponent.*;

public class LesJOBJ extends LesFil {
    @Override
    public void lesDatamaskin(Path path) throws ClassNotFoundException {
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            Datamaskin datamaskin;
            datamaskin = (Datamaskin) object;
            System.out.println(datamaskin);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lesKomponent(Path path) throws ClassNotFoundException {
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in))
        {
            Object object = oin.readObject();
            Komponent komponent;
            komponent= (Komponent) object;
            System.out.println(komponent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

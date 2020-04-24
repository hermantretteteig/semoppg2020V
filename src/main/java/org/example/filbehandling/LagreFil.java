package org.example.filbehandling;

import models.Person;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

import java.nio.file.Path;

public abstract class LagreFil {
    public abstract void lagreBruker(Person person, String filnavn);
    public abstract void lagreKomponent(Komponent komponent, String filnavn);
    public abstract void lagreDatamaskin(Datamaskin datamaskin, String filnavn);
}

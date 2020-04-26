package org.example.filbehandling;

import models.brukere.Bruker;
import models.komponent.Datamaskin;
import models.komponent.Komponent;

public abstract class LagreFil {
    public abstract void lagreBruker(Bruker bruker, String filnavn);
    public abstract void lagreKomponent(Komponent komponent, String filnavn);
    public abstract void lagreDatamaskin(Datamaskin datamaskin, String filnavn);
}

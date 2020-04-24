package org.example.filbehandling;

import java.nio.file.Path;

public abstract class LesFil {
    public abstract void lesDatamaskin(Path path) throws ClassNotFoundException;
    public abstract void lesKomponent(Path path) throws ClassNotFoundException;
}

package main;

import java.io.Serializable;

public abstract class Command implements Serializable {
    abstract void execute();
    abstract void undo();
}

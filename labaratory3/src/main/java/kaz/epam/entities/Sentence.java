package kaz.epam.entities;

import kaz.epam.interfaces.Entity;

public class Sentence implements Entity {

    private String string;

    public String getString() {return string;}

    public void setString(String string) {
        this.string = string;
    }
}

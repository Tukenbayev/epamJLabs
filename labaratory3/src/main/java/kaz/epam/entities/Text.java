package kaz.epam.entities;

import kaz.epam.interfaces.Entity;

public class Text implements Entity {

    private StringBuilder stringBuilder = new StringBuilder();
    private String string;

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public String getString(){return stringBuilder.toString();}

    public void setString(String string) {
        this.string = string;
    }


}

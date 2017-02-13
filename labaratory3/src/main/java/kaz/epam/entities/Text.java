package kaz.epam.entities;

import kaz.epam.interfaces.Entity;

public class Text implements Entity {

    private StringBuilder stringBuilder = new StringBuilder();
    private String string = stringBuilder.toString();

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public String getString(){return string;}

    public void setString(String string) {
        this.string = string;
    }


}

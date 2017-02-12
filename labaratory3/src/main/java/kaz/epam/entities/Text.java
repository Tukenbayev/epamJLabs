package kaz.epam.entities;

import java.io.IOException;
import java.io.Reader;


public class Text {

    private StringBuilder fullText = new StringBuilder();


    public StringBuilder getFullText() {
        return fullText;
    }

    public void setFullText(StringBuilder fullText) {
        this.fullText = fullText;
    }

}

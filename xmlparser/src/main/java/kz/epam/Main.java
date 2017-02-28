package kz.epam;

import kz.epam.parsers.MainParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        MainParser.parseXML("aircompany.xml");
        System.out.println(MainParser.checkCompanyEquality());
    }
}

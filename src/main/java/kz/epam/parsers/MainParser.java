package kz.epam.parsers;

import kz.epam.entities.aircompany.AirCompany;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainParser {

    private static List<AirCompany> companyList = new ArrayList<>();

    public static void parseXML(String fileName) throws ParserConfigurationException, SAXException, IOException {
        //SAX Parser
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        javax.xml.parsers.SAXParser sp = spf.newSAXParser();
        SAXParser handler = new SAXParser();
        sp.parse(new File(fileName), handler);

        companyList.add(handler.getCompany());


        //StAX Parser
        StAXParser parser = new StAXParser();
        InputStream input = new FileInputStream(fileName);
        parser.parse(input);

        companyList.add(parser.getCompany());

        //DOM Parser

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(fileName);
        Element root = document.getDocumentElement();

        companyList.add(DOMParser.establishAirCompany(root));
    }

    public static boolean checkCompanyEquality(){
        if (!companyList.get(0).equals(companyList.get(1)))
            return false;
        else if (!companyList.get(0).equals(companyList.get(2)))
            return false;
        else if (!companyList.get(1).equals(companyList.get(2)))
            return false;

        return true;
    }

}

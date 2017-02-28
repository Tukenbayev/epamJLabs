package kz.epam.parsers;

import kz.epam.entities.aircompany.AirCompany;
import kz.epam.entities.departments.FlightDepartment;
import kz.epam.entities.departments.TechnicalDepartment;
import kz.epam.entities.planes.*;
import kz.epam.entities.staff.AbstractEmployee;
import kz.epam.enums.AircompanyTags;
import kz.epam.factories.PlaneFactory;
import kz.epam.factories.StaffFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {

    private AirCompany company;
    private AbstractPlane plane;
    private AbstractEmployee employee;
    private StringBuilder elementValue = new StringBuilder();

    private String position;
    private int salary;


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "company:"+ AircompanyTags.AIRCOMPANY:
                company = new AirCompany(attributes.getValue(AircompanyTags.NAME_ATTR));
                break;
            case AircompanyTags.PLANE:
                plane = PlaneFactory.buildPlane(attributes.getValue(AircompanyTags.MODEL_ATTR));
                company.addPlane(plane);
                break;
            case AircompanyTags.DEPARTMENT:
                if (attributes.getValue(AircompanyTags.TYPE_ATTR).equals(AircompanyTags.TECHNICAL_DEPARTMENT))
                    company.setTechnicalDepartment(new TechnicalDepartment());
                else if (attributes.getValue(AircompanyTags.TYPE_ATTR).equals(AircompanyTags.FLIGHT_DEPARTMENT))
                    company.setFlightDepartment(new FlightDepartment());
                break;
        }

        if (qName.equals(AircompanyTags.PILOT) || qName.equals(AircompanyTags.AIRSTEWARD) || qName.equals(AircompanyTags.TECHNICAL_STAFF))
            employee = StaffFactory.hireEmployee(qName);

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case AircompanyTags.SALARY:
                salary = Integer.parseInt(elementValue.toString().trim());
                employee.setSalary(salary);
                elementValue = new StringBuilder();
                break;
            case AircompanyTags.POSITION:
                position = elementValue.toString().trim();
                employee.improvePosition(position);
                elementValue = new StringBuilder();
                break;
            case AircompanyTags.TECHNICAL_STAFF:
                company.getTechnicalDepartment().addEmployee(employee);
                break;
            case AircompanyTags.PILOT:
            case AircompanyTags.AIRSTEWARD:
                company.getFlightDepartment().addEmployee(employee);
                break;
        }

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue.append(ch,start,length);
    }

    public AirCompany getCompany() {
        return company;
    }

    public void setCompany(AirCompany company) {
        this.company = company;
    }

}

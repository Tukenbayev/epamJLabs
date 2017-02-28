package kz.epam.parsers;

import kz.epam.entities.aircompany.AirCompany;
import kz.epam.entities.departments.FlightDepartment;
import kz.epam.entities.departments.TechnicalDepartment;
import kz.epam.entities.staff.AbstractEmployee;
import kz.epam.enums.AircompanyTags;
import kz.epam.factories.PlaneFactory;
import kz.epam.factories.StaffFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXParser {

    private AirCompany company = new AirCompany();
    private AbstractEmployee employee;
    private String buffer;

    public void parse(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    private void process(XMLStreamReader reader) throws XMLStreamException {

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    if(reader.getLocalName().equals(AircompanyTags.AIRCOMPANY))
                        company.setCompanyName(reader.getAttributeValue(null,AircompanyTags.NAME_ATTR));
                    else if(reader.getLocalName().equals(AircompanyTags.PLANE))
                        company.addPlane(PlaneFactory.buildPlane(reader.getAttributeValue(null,AircompanyTags.MODEL_ATTR)));
                    else if(reader.getLocalName().equals(AircompanyTags.DEPARTMENT)){
                        if (reader.getAttributeValue(null,AircompanyTags.TYPE_ATTR).equals(AircompanyTags.TECHNICAL_DEPARTMENT))
                            company.setTechnicalDepartment(new TechnicalDepartment());
                        else if(reader.getAttributeValue(null,AircompanyTags.TYPE_ATTR).equals(AircompanyTags.FLIGHT_DEPARTMENT))
                            company.setFlightDepartment(new FlightDepartment());
                    }
                    else if (reader.getLocalName().equals(AircompanyTags.PILOT) || reader.getLocalName().equals(AircompanyTags.AIRSTEWARD)||
                            reader.getLocalName().equals(AircompanyTags.TECHNICAL_STAFF))
                        employee = StaffFactory.hireEmployee(reader.getLocalName());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (reader.getLocalName().equals(AircompanyTags.POSITION) && employee instanceof AbstractEmployee)
                        employee.improvePosition(buffer);
                    else if (reader.getLocalName().equals(AircompanyTags.SALARY) && employee instanceof AbstractEmployee)
                        employee.setSalary(Integer.parseInt(buffer));
                    else if(reader.getLocalName().equals(AircompanyTags.PILOT) ||
                            reader.getLocalName().equals(AircompanyTags.AIRSTEWARD))
                        company.getFlightDepartment().addEmployee(employee);
                    else if(reader.getLocalName().equals(AircompanyTags.TECHNICAL_STAFF))
                        company.getTechnicalDepartment().addEmployee(employee);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    buffer = reader.getText().trim();
                    break;
            }
        }
    }


    public AirCompany getCompany() {
        return company;
    }
}

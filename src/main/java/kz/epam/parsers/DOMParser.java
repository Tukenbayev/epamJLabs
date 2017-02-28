package kz.epam.parsers;

import kz.epam.entities.aircompany.AirCompany;
import kz.epam.entities.departments.FlightDepartment;
import kz.epam.entities.departments.TechnicalDepartment;
import kz.epam.entities.staff.AbstractEmployee;
import kz.epam.enums.AircompanyTags;
import kz.epam.factories.PlaneFactory;
import kz.epam.factories.StaffFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {

    public static AirCompany establishAirCompany(Element root){
        AirCompany airCompany = new AirCompany();
        airCompany.setCompanyName(root.getAttribute(AircompanyTags.NAME_ATTR));

        // plane building
        NodeList planeNodes = root.getElementsByTagName(AircompanyTags.PLANE);
        for (int i = 0; i < planeNodes.getLength(); i++) {
            Element planeElement = (Element) planeNodes.item(i);
            airCompany.addPlane(PlaneFactory.buildPlane(planeElement.getAttribute(AircompanyTags.MODEL_ATTR)));
        }

        // setting departments
        NodeList departments  = root.getElementsByTagName(AircompanyTags.DEPARTMENT);
        for (int i = 0; i < departments.getLength();i++){
            Element department = (Element) departments.item(i);
            if (department.getAttribute(AircompanyTags.TYPE_ATTR).equals(AircompanyTags.TECHNICAL_DEPARTMENT))
                airCompany.setTechnicalDepartment(new TechnicalDepartment());
            else if(department.getAttribute(AircompanyTags.TYPE_ATTR).equals(AircompanyTags.FLIGHT_DEPARTMENT))
                airCompany.setFlightDepartment(new FlightDepartment());

            // hiring technical staff
            NodeList technicalStaff = department.getElementsByTagName(AircompanyTags.TECHNICAL_STAFF);
            if (technicalStaff != null && technicalStaff.getLength()>0)
                for (int j = 0; j<technicalStaff.getLength();j++){
                    Element techStaff = (Element) technicalStaff.item(j);
                    AbstractEmployee employee = StaffFactory.hireEmployee(AircompanyTags.TECHNICAL_STAFF);
                    employee.setSalary(Integer.parseInt(getChildValue(techStaff,AircompanyTags.SALARY)));
                    employee.improvePosition(getChildValue(techStaff,AircompanyTags.POSITION));
                    airCompany.getTechnicalDepartment().addEmployee(employee);
                }

            //hiring pilots
            NodeList flightStaff = department.getElementsByTagName(AircompanyTags.PILOT);
            NodeList airstewards = department.getElementsByTagName(AircompanyTags.AIRSTEWARD);
            if (flightStaff != null && flightStaff.getLength()>0)
                for (int j = 0; j<flightStaff.getLength();j++){
                    Element flightSt = (Element) flightStaff.item(j);
                    AbstractEmployee employee = StaffFactory.hireEmployee(AircompanyTags.PILOT);
                    employee.setSalary(Integer.parseInt(getChildValue(flightSt,AircompanyTags.SALARY)));
                    employee.improvePosition(getChildValue(flightSt,AircompanyTags.POSITION));
                    airCompany.getFlightDepartment().addEmployee(employee);
                }
            //hiring airstewards
            if (airstewards != null && airstewards.getLength()>0)
                for (int j = 0; j<airstewards.getLength();j++){
                    Element airsteward = (Element) airstewards.item(j);
                    AbstractEmployee employee = StaffFactory.hireEmployee(AircompanyTags.AIRSTEWARD);
                    employee.setSalary(Integer.parseInt(getChildValue(airsteward,AircompanyTags.SALARY)));
                    employee.improvePosition(getChildValue(airsteward,AircompanyTags.POSITION));
                    airCompany.getFlightDepartment().addEmployee(employee);
                }

        }

        return airCompany;
    }

    private static Element getChildren(Element parent, String childName) {
        NodeList nlist = parent.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }
    // возвращает текст, содержащийся в элементе
    private static String getChildValue(Element parent, String childName) {
        Element child = getChildren(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value.trim();
    }

}

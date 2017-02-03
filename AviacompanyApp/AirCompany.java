package AviacompanyApp;

import AviacompanyApp.interfaces.Department;
import AviacompanyApp.interfaces.Plane;


import java.util.ArrayList;

public class AirCompany {

    private final String companyName;
    private ArrayList<Plane> planes = new ArrayList<>();
    private ArrayList<Department> technicalDepartment;
    private ArrayList<Department> flightDepartment;


    public AirCompany(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    public ArrayList<Department> getTechnicalDepartment() {
        return technicalDepartment;
    }

    public void setTechnicalDepartment(ArrayList<Department> technicalDepartment) {
        this.technicalDepartment = technicalDepartment;
    }

    public ArrayList<Department> getFlightDepartment() {
        return flightDepartment;
    }

    public void setFlightDepartment(ArrayList<Department> flightDepartment) {
        this.flightDepartment = flightDepartment;
    }
}

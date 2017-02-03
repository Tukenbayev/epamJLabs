package AviacompanyApp;

import AviacompanyApp.interfaces.Department;
import AviacompanyApp.interfaces.Plane;
import AviacompanyApp.planes.AbstractPlane;


import java.util.ArrayList;
import java.util.Collections;

public class AirCompany {

    private final String companyName;
    private ArrayList<AbstractPlane> planes = new ArrayList<>();
    private ArrayList<Department> technicalDepartment;
    private ArrayList<Department> flightDepartment;


    public AirCompany(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void sortPlanesByRangeOfFlight(){
        Collections.sort(planes);
    }

    public Plane findAppropriatePlane(int fuelConsumption1, int fuelConsumption2){
        for(AbstractPlane plane : planes){
            int currentPlaneCons = plane.getFuelTankCapacity()/plane.getRangeOfFlight();
            if (currentPlaneCons>= fuelConsumption1 && currentPlaneCons<=fuelConsumption2)
                return plane;
        }

        return null;
    }

    public ArrayList<AbstractPlane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<AbstractPlane> planes) {
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

package kz.epam.entities.aircompany;



import kz.epam.entities.departments.FlightDepartment;
import kz.epam.entities.departments.TechnicalDepartment;
import kz.epam.entities.planes.AbstractPlane;

import java.util.ArrayList;
import java.util.Collections;

public class AirCompany {

    private String companyName;
    private ArrayList<AbstractPlane> planes = new ArrayList<AbstractPlane>();
    private TechnicalDepartment technicalDepartment;
    private FlightDepartment flightDepartment;

    public AirCompany(){}
    public AirCompany(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void sortPlanesByRangeOfFlight(){
        Collections.sort(planes);
    }

    public AbstractPlane findAppropriatePlane(int fuelConsumption1, int fuelConsumption2){
        for(AbstractPlane plane : planes){
            int currentPlaneCons = plane.getFuelTankCapacity()/plane.getRangeOfFlight();
            if (currentPlaneCons>= fuelConsumption1 && currentPlaneCons<=fuelConsumption2)
                return plane;
        }

        return null;
    }

    public void addPlane(AbstractPlane plane){planes.add(plane);}

    public ArrayList<AbstractPlane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<AbstractPlane> planes) {
        this.planes = planes;
    }

    public TechnicalDepartment getTechnicalDepartment() {
        return technicalDepartment;
    }

    public void setTechnicalDepartment(TechnicalDepartment technicalDepartment) {
        this.technicalDepartment = technicalDepartment;
    }

    public FlightDepartment getFlightDepartment() {
        return flightDepartment;
    }

    public void setFlightDepartment(FlightDepartment flightDepartment) {
        this.flightDepartment = flightDepartment;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public boolean equals(AirCompany company) {
        if (!companyName.equals(company.getCompanyName()))
            return false;

        for (int i = 0; i< planes.size(); i++){
            if (!planes.get(i).equals(company.getPlanes().get(i)))
                return false;
        }

        if (!technicalDepartment.equals(company.getTechnicalDepartment()))
            return false;

        if (!flightDepartment.equals(company.getFlightDepartment()))
            return false;

        return true;
    }


}

package AviacompanyApp.staff;

import AviacompanyApp.interfaces.Plane;

public class TechnicalStaff extends AbstractEmployee {

    public TechnicalStaff(String position, int salary){
        super(position,salary);
    }

    public Plane preparePlane(Plane plane){
        //todo

        return plane;
    }

    public boolean refuelPlane(Plane plane){
        //todo

        return true;
    }


}

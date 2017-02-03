package AviacompanyApp.staff;

import AviacompanyApp.interfaces.Plane;

public class Pilot extends AbstractEmployee {

    private Plane plane;


    public Pilot(String position, int salary){
        super(position, salary);
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void aviatePlane(){
        //todo
    }

    public void landPlane(){
        //todo
    }

    public void takeOffPlane(){
        //todo
    }
}

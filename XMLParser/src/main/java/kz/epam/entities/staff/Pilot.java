package kz.epam.entities.staff;


import kz.epam.entities.planes.AbstractPlane;

public class Pilot extends AbstractEmployee {

    private AbstractPlane plane;

    public Pilot(){}
    public Pilot(String position, int salary){
        super(position, salary);
    }

    public void setPlane(AbstractPlane plane) {
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

package kz.epam.entities.staff;


import kz.epam.entities.planes.AbstractPlane;

public class TechnicalStaff extends AbstractEmployee {
    public TechnicalStaff(){}

    public TechnicalStaff(String position, int salary){
        super(position,salary);
    }

    public AbstractPlane preparePlane(AbstractPlane plane){
        //todo

        return plane;
    }

    public boolean refuelPlane(AbstractPlane plane){
        //todo

        return true;
    }


}

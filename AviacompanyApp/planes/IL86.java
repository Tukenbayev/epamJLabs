package AviacompanyApp.planes;

public class IL86 extends AbstractPlane  {

    public IL86(){
        super(
                "IL86", // model
                120, // seats
                20, // fuel tank capacity
                3500, // range of flight
                true, // has business class
                50, // max carrying capacity
                950 // speed
        );
    }
}

package AviacompanyApp.planes;

public class TU134 extends AbstractPlane {

    public TU134(){
        super(
                "TU134", // model
                96, // seats
                13, // fuel tank capacity
                2500, // range of flight
                true, // has business class
                47, // max carrying capacity
                850 // speed
        );
    }
}

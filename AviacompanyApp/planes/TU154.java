package AviacompanyApp.planes;

public class TU154 extends AbstractPlane {

    public TU154(){
        super(
                "TU154", // model
                126, // seats
                19, // fuel tank capacity
                3500, // range of flight
                true, // has business class
                80, // max carrying capacity
                900 // speed
        );
    }
}

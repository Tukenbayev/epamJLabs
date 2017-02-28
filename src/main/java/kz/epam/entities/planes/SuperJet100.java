package kz.epam.entities.planes;

public class SuperJet100 extends AbstractPlane{

    public SuperJet100(){
        super(
                "SuperJet - 100", // model
                60, // seats
                15, // fuel tank capacity
                3000
        );
    }
}

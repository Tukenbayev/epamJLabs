package kz.epam.factories;

import kz.epam.entities.planes.*;

public class PlaneFactory {

    public static final String IL86 = "IL86";
    public static final String SuperJet100 = "SuperJet100";
    public static final String TU134 = "TU134";
    public static final String TU154 = "TU154";

    public static AbstractPlane buildPlane(String model){
        switch (model) {
            case IL86:
                return new IL86();
            case SuperJet100:
                return new SuperJet100();
            case TU134:
                return new TU134();
            case TU154:
                return new TU154();
        }

        return null;
    }
}

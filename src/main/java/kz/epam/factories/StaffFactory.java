package kz.epam.factories;

import kz.epam.entities.staff.AbstractEmployee;
import kz.epam.entities.staff.AirSteward;
import kz.epam.entities.staff.Pilot;
import kz.epam.entities.staff.TechnicalStaff;
import kz.epam.enums.AircompanyTags;

public class StaffFactory {

    public static AbstractEmployee hireEmployee(String employee){
        switch (employee) {
            case AircompanyTags.TECHNICAL_STAFF:
                return new TechnicalStaff();
            case AircompanyTags.PILOT:
                return new Pilot();
            case AircompanyTags.AIRSTEWARD:
                return new AirSteward();
        }
        return null;
    }
}

package kz.epam.entities.departments;


import kz.epam.entities.staff.AbstractEmployee;

import java.util.ArrayList;

public class TechnicalDepartment {

    private ArrayList<AbstractEmployee> technicalEmployeeList = new ArrayList<AbstractEmployee>();

    public ArrayList<AbstractEmployee> getEmployeeList() {
        return technicalEmployeeList;
    }

    public void addEmployee(AbstractEmployee employee) {
        technicalEmployeeList.add(employee);
    }

    public boolean fireEmployee(AbstractEmployee employee) {
        return technicalEmployeeList.remove(employee);
    }

    public boolean equals(TechnicalDepartment department){

        for (int i = 0; i<technicalEmployeeList.size();i++){
            if (!technicalEmployeeList.get(i).equals(department.getEmployeeList().get(i)))
                return false;
        }

        return true;
    }
}

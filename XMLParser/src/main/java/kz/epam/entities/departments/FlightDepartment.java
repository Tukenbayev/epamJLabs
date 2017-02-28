package kz.epam.entities.departments;



import kz.epam.entities.staff.AbstractEmployee;

import java.util.ArrayList;

public class FlightDepartment {

    private ArrayList<AbstractEmployee> employeeList = new ArrayList<AbstractEmployee>();

    public void addEmployee(AbstractEmployee employee) {
        employeeList.add(employee);
    }

    public boolean fireEmployee(AbstractEmployee employee) {
        return employeeList.remove(employee);
    }

    public void setEmployeeList(ArrayList<AbstractEmployee> employeeList) {
        this.employeeList = employeeList;
    }

    public ArrayList<AbstractEmployee> getEmployeeList() {
        return employeeList;
    }

    public boolean equals(FlightDepartment department){

        for (int i = 0; i<employeeList.size();i++){
            if (!employeeList.get(i).equals(department.getEmployeeList().get(i)))
                return false;
        }

        return true;
    }

}

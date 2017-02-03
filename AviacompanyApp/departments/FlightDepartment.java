package AviacompanyApp.departments;

import AviacompanyApp.interfaces.Department;
import AviacompanyApp.interfaces.Employee;
import AviacompanyApp.interfaces.Plane;

import java.util.ArrayList;

public class FlightDepartment implements Department {

    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Plane> planeList = new ArrayList<>();


    @Override
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public boolean fireEmployee(Employee employee) {
        return employeeList.remove(employee);
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setPlaneList(ArrayList<Plane> planeList) {
        this.planeList = planeList;
    }

    public ArrayList<Plane> getPlaneList() {
        return planeList;
    }
}

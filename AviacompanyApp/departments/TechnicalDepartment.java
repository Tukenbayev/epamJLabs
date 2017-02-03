package AviacompanyApp.departments;

import AviacompanyApp.interfaces.Department;
import AviacompanyApp.interfaces.Employee;

import java.util.ArrayList;

public class TechnicalDepartment implements Department {

    private ArrayList<Employee> technicalEmployeeList = new ArrayList<>();

    @Override
    public ArrayList<Employee> getEmployeeList() {
        return technicalEmployeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        technicalEmployeeList.add(employee);
    }

    @Override
    public boolean fireEmployee(Employee employee) {
        return technicalEmployeeList.remove(employee);
    }
}

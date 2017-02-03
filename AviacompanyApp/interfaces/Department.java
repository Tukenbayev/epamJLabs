package AviacompanyApp.interfaces;

import java.util.ArrayList;

/**
 * Created by Asus on 03.02.2017.
 */
public interface Department {

    ArrayList<Employee> getEmployeeList();

    void addEmployee(Employee employee);

    boolean fireEmployee(Employee employee);

}

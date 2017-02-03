package AviacompanyApp.staff;

import AviacompanyApp.interfaces.Employee;

public class AbstractEmployee implements Employee {

    private String position;
    private int salary;

    public AbstractEmployee(){}

    public AbstractEmployee(String position, int salary){
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void improvePosition(String position) {
        this.position = position;
    }

    public void setSalary(int newSalary){
        this.salary = newSalary;
    }


}

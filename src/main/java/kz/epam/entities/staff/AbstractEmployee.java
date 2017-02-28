package kz.epam.entities.staff;



public class AbstractEmployee {

    private String position;
    private int salary;

    public AbstractEmployee(){}

    public AbstractEmployee(int salary){
        this.salary = salary;
    }

    public AbstractEmployee(String position, int salary){
        this.position = position;
        this.salary = salary;
    }


    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void improvePosition(String position) {
        this.position = position;
    }

    public void setSalary(int newSalary){
        this.salary = newSalary;
    }

    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public boolean equals(AbstractEmployee employee){
        if (!position.equals(employee.getPosition()))
            return false;
        if (salary != employee.getSalary())
            return false;

        return true;
    }
}

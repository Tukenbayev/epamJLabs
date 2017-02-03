package AviacompanyApp.planes;

import AviacompanyApp.interfaces.Plane;

public class AbstractPlane implements Plane, Comparable<AbstractPlane>{

    private String model;
    private int seats;
    private int fuelTankCapacity; // tonnes
    private int rangeOfFlight; // kilometers
    private boolean hasBusinessClass;
    private int carryingCapacity; // tonnes
    private int speed; // kilometer/hour

    public AbstractPlane(String model){
        this.model = model;
    }

    public AbstractPlane(String model, int seats, int fuelTankCapacity,int range,boolean hasBusinessClass, int carryingCapacity, int speed){
        this.model = model;
        this.seats = seats;
        this.fuelTankCapacity = fuelTankCapacity;
        this.rangeOfFlight = range;
        this.hasBusinessClass = hasBusinessClass;
        this.carryingCapacity = carryingCapacity;
        this.speed = speed;

    }
    @Override
    public boolean land() {
        //todo
        return true;
    }

    @Override
    public boolean takeoff() {
        //todo
        return true;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public int getRangeOfFlight() {
        return rangeOfFlight;
    }

    public boolean isHasBusinessClass() {
        return hasBusinessClass;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int compareTo(AbstractPlane plane) {
        return this.rangeOfFlight - plane.rangeOfFlight;
    }
}

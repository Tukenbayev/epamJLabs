package kz.epam.entities.planes;


public class AbstractPlane implements Comparable<AbstractPlane>{

    private String model;
    private int seats;
    private int fuelTankCapacity; // tonnes
    private int rangeOfFlight; // kilometers


    public AbstractPlane(String model){
        this.model = model;
    }

    public AbstractPlane(String model, int seats, int fuelTankCapacity,int range){
        this.model = model;
        this.seats = seats;
        this.fuelTankCapacity = fuelTankCapacity;
        this.rangeOfFlight = range;

    }


    public boolean land() {
        //todo
        return true;
    }


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

    @Override
    public String toString() {
        return "AbstractPlane{" +
                "model='" + model + '\'' +
                ", seats=" + seats +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", rangeOfFlight=" + rangeOfFlight +
                '}';
    }

    public int compareTo(AbstractPlane plane) {
        return this.rangeOfFlight - plane.rangeOfFlight;
    }

    public boolean equals(AbstractPlane plane){
        if (!model.equals(plane.getModel()))
            return false;
        if (seats != plane.getSeats())
            return false;
        if (fuelTankCapacity != plane.getFuelTankCapacity())
            return false;
        if (rangeOfFlight != plane.getRangeOfFlight())
            return false;

        return true;
    }
}

package restservice.model;

public class Motorcycle extends Vehicle {
    private final int numOfWheels;

    public Motorcycle(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure, double[] tiresArr) {
        super(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, "Motorcycle", tiresArr);
        numOfWheels = 2;
    }

    void display() {
        System.out.println("Truck details:");
        super.display();
        System.out.println("Number of wheels : " + numOfWheels);

    }
}
package restservice.model;

public class Truck extends Vehicle {
    private final String energySource;

    public Truck(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure,  double[] tiresArr) {
        super(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, "Truck", tiresArr);
        numOfWheels = 16;
        energySource = "fuel tank";
    }

    void display() {
        System.out.println("Truck details:");
        super.display();
        System.out.println("Number of wheels : " + numOfWheels);
        System.out.println("Energy source: " + energySource);
    }
}
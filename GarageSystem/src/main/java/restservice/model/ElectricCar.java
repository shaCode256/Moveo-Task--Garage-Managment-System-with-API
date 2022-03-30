package restservice.model;

public class ElectricCar extends Car {
    private final String energySource;

    public ElectricCar(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure, double[] tiresArr) {
        super(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
        this.energySource = "battery";
    }

    void display() {
        System.out.println("Car details:");
        super.display();
        System.out.println("Energy Source : " + energySource);
    }
}
package restservice.model;

public class ElectricMotorcycle extends Motorcycle {
    String energySource;

    public ElectricMotorcycle(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure,  double[] tiresArr) {
        super(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
        this.energySource = "battery";
    }

    void display() {
        super.display();
        System.out.println("Energy Source : " + energySource);
    }
}
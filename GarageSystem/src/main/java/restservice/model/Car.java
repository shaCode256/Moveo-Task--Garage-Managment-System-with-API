package restservice.model;


public class Car extends Vehicle {

    public Car(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure, double[] tiresArr) {
        super(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, "Car", tiresArr);
        numOfWheels = 4;
    }

    void display() {
        System.out.println("Car details:");
        super.display();
        System.out.println("Number of wheels : " + numOfWheels);
    }
}
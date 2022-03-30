package restservice.model;

import restservice.controller.exceptionsHandling.ApiRequestExceptions;

public class Vehicle {
    private static int numberOfVehicles = 0;
    protected double[] tiresArray;
    private String model = "";
    private String licenseNumber = "";
    private double availableEnergyLeftPerc = 0;
    private double maximumTirePressure = 0;
    private final String energySource = "";
    private String type="";
    int numOfWheels;



    // Parameterized Constructor
    public Vehicle(double availableEnergyLeftPerc, String licenseNumber, String model, double maximumTirePressure, String type, double[] tiresArray) {
        this.availableEnergyLeftPerc = availableEnergyLeftPerc;
        this.licenseNumber = licenseNumber;
        this.model = model;
        this.maximumTirePressure = maximumTirePressure;
        this.type=type;
        this.tiresArray=  tiresArray;
        numberOfVehicles++;
    }


    public double getAvailableEnergyLeftPerc() {
        return availableEnergyLeftPerc;
    }

    public void setAvailableEnergyLeftPerc(double setAvailableEnergyLeftPerc) {
        this.availableEnergyLeftPerc = availableEnergyLeftPerc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnergySource() {
        return energySource;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public double getMaximumTirePressure() {
        return maximumTirePressure;
    }

    public void setMaximumTirePressure(double maximumTirePressure) {
        this.maximumTirePressure = maximumTirePressure;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double[] getTyresArray() {
        return this.tiresArray;
    }

    public void setTyres(double[] tyres) {
        this.tiresArray = tiresArray;
    }
    //to manage tires array

    // public method to print details
    void display() {
        System.out.println("Available Energy Left Percentage: " + availableEnergyLeftPerc);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Maximum Tire Pressure: " + maximumTirePressure);
        System.out.println("Model: " + model);
        System.out.println("Energy Source: " + energySource);
        System.out.println("Tires pressure: "+ tiresArray);
    }

    public void refillEnergy(double percentage) {
        //refuel or recharge the battery
        if(percentage <= this.availableEnergyLeftPerc) {
            throw new ApiRequestExceptions("You already have this energy percentage/ even more");
        }
        this.availableEnergyLeftPerc = percentage;
    }

    void InflateTires() {
        for (int i=0; i<tiresArray.length; i++) {
            tiresArray[i]= maximumTirePressure;
        }
    }

}
package restservice.model;

import org.springframework.stereotype.Service;
import restservice.controller.exceptionsHandling.ApiRequestExceptions;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class Garage {

    
    static HashMap<String, Vehicle> VehiclesMap = new HashMap<String, Vehicle>();

    static ArrayList<String> typeList= new ArrayList<>();

    public void setTypesList(ArrayList<String> typeList) {
        this.typeList= typeList;
    }
    public ArrayList<String> getTypesList() {
        return typeList;
    }

    public static int getNumberOfVehicles() {
        return VehiclesMap.size();
    }

    public void addVehicle(String type, Vehicle vehicle) {
        System.out.println(vehicle.getTyresArray());
        double availableEnergyLeftPerc= vehicle.getAvailableEnergyLeftPerc();
        String licenseNumber= vehicle.getLicenseNumber();
        String model= vehicle.getModel();
        double maximumTirePressure= vehicle.getMaximumTirePressure();
        Vehicle instance = null;
        double[] tiresArr= vehicle.getTyresArray();
        System.out.println("hey"+tiresArr);
        switch(type){
            case "car":
                instance = new Car(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
                break;
            case "electricCar":
                instance = new ElectricCar(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
                break;
            case "electricMotorcycle":
                instance = new ElectricCar(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
                break;
            case "motorcycle":
                instance = new Motorcycle(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
                break;
            case "truck":
                instance = new Truck(availableEnergyLeftPerc, licenseNumber, model, maximumTirePressure, tiresArr);
                break;
        }
        if ((vehicle.getTyresArray()!=null && vehicle.getTyresArray().length!= instance.numOfWheels)){
            throw new ApiRequestExceptions("wrong number of tires you specified in the JSON");
        }
        VehiclesMap.put(vehicle.getLicenseNumber(), instance);
    }

    public void displayVehicles() {
        for (HashMap.Entry<String, Vehicle> entry : VehiclesMap.entrySet()) {
            String key = entry.getKey();
            Vehicle value = entry.getValue();
            value.display();
        }
    }

    public HashMap<String, Vehicle> getAllVehicles() {
        return VehiclesMap;
    }

    public void emptyGarage() {
        VehiclesMap.clear();
    }


    public void inflateVehicleTires(String licenseNumber) {
        VehiclesMap.get(licenseNumber).InflateTires();
    }

    public Vehicle getVehicleByLicense(String licenseNum) {
        return VehiclesMap.get(licenseNum);
    }

    public void refillEnergyByLicense(String licenseNum, double percentage) {
        VehiclesMap.get(licenseNum).refillEnergy(percentage);
    }


    public void removeVehicle(String licenseNumber) {
        VehiclesMap.remove(licenseNumber);
    }


}

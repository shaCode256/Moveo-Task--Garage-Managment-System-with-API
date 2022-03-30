package restservice.controller;

import restservice.controller.exceptionsHandling.ApiRequestExceptions;
import restservice.model.Garage;
import restservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is a controller for the Rest API
 * it has the basics operations of POST, GET, PUT and DELETE
 *
 * @author Shavit Luzon
 */

@RequestMapping("/api/1.0/garage")
@RestController
public class GarageController {

    private Garage garageService;
    @Autowired
    public GarageController(Garage garageService) {
        this.garageService = garageService;
    }

    @PostMapping(value = "{type}")
    public void addVehicle(@PathVariable("type") String licenseNumber, @RequestBody Vehicle vehicle) {
        ArrayList<String> typeList= new ArrayList<>();
        typeList.add("car");
        typeList.add("electricCar");
        typeList.add("electricMotorcycle");
        typeList.add("motorcycle");
        typeList.add("truck");
        garageService.setTypesList(typeList);
        if (garageService.getAllVehicles().containsKey(vehicle.getLicenseNumber())) {
            throw new ApiRequestExceptions("This vehicle is already in the collection");
        }
        String type= vehicle.getType();
        if (!garageService.getTypesList().contains(type) || !vehicle.getType().equals(type)) {
            throw new ApiRequestExceptions("Invalid input. you must provide the same valid type with" +
                    " of vehicle in the JSON format and in the POST request");
        }
        garageService.addVehicle(type, vehicle);
    }

    @GetMapping
    public HashMap<String, Vehicle> getAllVehicles() {
        return garageService.getAllVehicles();
    }

    @GetMapping(value = "{licenseNumber}")
    public Vehicle getVehicle(@PathVariable("licenseNumber") String licenseNumber) {
        if (!garageService.getAllVehicles().containsKey(licenseNumber)) {
            throw new ApiRequestExceptions("This vehicle is not in the collection");
        }
        return garageService.getVehicleByLicense(licenseNumber);
    }

    @PutMapping(value = "{licenseNumber}")
    public void inflateTires(@PathVariable("licenseNumber") String licenseNumber) {
        if (!garageService.getAllVehicles().containsKey(licenseNumber)) {
            throw new ApiRequestExceptions("This vehicle is not in the collection");
        }
        garageService.inflateVehicleTires(licenseNumber);
    }

    @PutMapping(value = "{licenseNumber}/{percentage}")
    public void refillEnergy(@PathVariable("licenseNumber") String licenseNumber, @PathVariable("percentage") double percentage) {
        if (!garageService.getAllVehicles().containsKey(licenseNumber)) {
            throw new ApiRequestExceptions("This vehicle is not in the collection");
        }
        garageService.getVehicleByLicense(licenseNumber).refillEnergy(percentage);
    }

    @DeleteMapping(value = "{licenceNumber}")
    public void removeVehicleByLicenceNumber(@PathVariable("licenceNumber") String licenseNumber) {
        if (!garageService.getAllVehicles().containsKey(licenseNumber)) {
            throw new ApiRequestExceptions("This vehicle is not in the collection");
        }
        garageService.removeVehicle(licenseNumber);

    }

    @DeleteMapping()
    public void emptyGarage() {
        garageService.emptyGarage();
    }

}

# Moveo- Garage with Rest-API
### Author : Shavit @ShaCode256 

## Description

This project represent a Garage Management System, with REST-API server.
Built in JAVA, using Maven and SpringBoot.
It can manage various types of vehicles and should be extensible in case 
we need to add new types of vehicles.
Each vehicle has unique properties and functionalities according to its type.
The system allows the management of the vehicles by adding viewing and performing various actions on the vehicles.

## Specifications:
There are 5 types of vehicles as follows:
Regular motorcycle
Electric motorcycle
Regular car
Electric car
Truck

All of the vehicles have an energy source (battery or fuel tank)
and a collection of wheels, motorcycles have 2, cars 4, and trucks have 16 wheels.

### Each vehicle has the following properties:
Model name
License number
Available energy percentage (how much battery or fuel is left)
Maximum tire pressure
Inflate tire
Add energy(refuel or recharge the battery

The garage system is as modular as possible while incorporating OOP concepts.

## The REST-API of this project:
implement a simple HTTP based API that exposes the following endpoints:
Add a new vehicle to the vehicle's collection
Retrieve a single vehicle by license number
Retrieve all of the available vehicles
Inflate vehicle tires to maximum pressure
Add energy (Refuel a vehicle or recharge) by license number

### Prerequisites:
* IDE
* client platform, for example "PostMan"

### Installation Instructions
* Clone/Download and unzip(if needed) this repository.
* open this project in your IDE 
* Run the RestServiceApplication class
* Open your client platform and use it to communicate with the server

## USING THE REST API
### Instructions and examples
### All explained as it is in PostMan Software


*POST*
  To add a new car to the garage:
  choose POST. 
  type this url http://localhost:8080/api/1.0/garage/{licenseNumber}
  In Body section choose *Raw* and fill the JSON format
     
      { "type": String,
      "model": String,
      "licenseNumber": String,
      "energyPercentage": double,
      "tirePressure": double,
      "maximumTirePressure": double,
      "energySource": String,
      "tyresArray": double []}
      
      for example:
      { "type": "car", 
      "model": "newModel",
      "licenseNumber": "1234",
      "availableEnergyLeftPerc": 0.0,
      "maximumTirePressure": 10.0,
      "energySource": "Fuel",
      "tyresArray": [6.0,7.0,5.3] }
      
 
  **put**
  1) To Inflate the tires to the maximum pressure:
  choose PUT and type this url: http://localhost:8080/api/1.0/garage/{lisenceNumber}
  2) To  Add energy choose PUT and type this url http://localhost:8080/api/1.0/garage/{lisenceNumber}/{energy}
  
  **get**
  1) To retrieve a car form the garage choose GET and type this url http://localhost:8080/api/1.0/garage/{lisenceNumber}
  2) To get all the cars in the garage choose GET and type this url http://localhost:8080/api/1.0/garage
  
  **delete**
  1) To delete a car form the garage choose DELETE and type this url http://localhost:8080/api/1.0/garage/{lisenceNumber}
  2) To get all the cars in the garage choose DELETE and type this url http://localhost:8080/api/1.0/garage
  
 
  ## Swagger Documentation
  To see the swagger documentation of the project,
  run the application (RestServiceApplication.java) 
  and insert this url in a web browser:
  http://localhost:8080/swagger-ui.html#/
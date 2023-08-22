package com.api.VehicleRental.controller;

import com.api.VehicleRental.model.Vehicle;
import com.api.VehicleRental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public String createVehicleHandler(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return "Vehicle Created Successfully";
    }

    @GetMapping
    public List<Vehicle> getAllVehiclesHandler() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("{vehicleId}")
    public Vehicle getVehicleHandler(@PathVariable int vehicleId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        logger.info("Vehicle Found Successfully: {}", vehicle);
        return vehicle;
    }

    @PutMapping("{vehicleId}")
    public Vehicle updateVehicleHandler(@PathVariable int vehicleId, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleId, vehicle);
        logger.info("Vehicle Updated Successfully {}", updatedVehicle);
        return updatedVehicle;
    }
    
    @DeleteMapping("{vehicleId}")
    public String deleteVehicleHandler(@PathVariable int vehicleId) {
    	if(vehicleService.deleteVehicle(vehicleId)) {
    		logger.info("Vehicle Deleted Successfully");
    		return "Vehicle Deleted Successfully";
    	}
    	return "Vehicle Not Found";
    }
}

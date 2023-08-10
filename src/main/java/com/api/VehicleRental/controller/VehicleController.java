package com.api.VehicleRental.controller;

import com.api.VehicleRental.model.Vehicle;
import com.api.VehicleRental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
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

    public List<Vehicle> getAllVehiclesHandler() {
        return vehicleService.getAllVehicles();
    }

    public Vehicle getVehicleHandler(int vehicleId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        logger.info("Vehicle Found Successfully: {}", vehicle);
        return vehicle;
    }
}

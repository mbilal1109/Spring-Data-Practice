package com.api.VehicleRental.serviceimpl;

import com.api.VehicleRental.model.Vehicle;
import com.api.VehicleRental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class VehicleServiceImpl implements VehicleService {

	// Using List as temp DB, need to change later.
    List<Vehicle> vehicles = new ArrayList<>();

    private final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        return vehicles.stream().filter(v -> v.getVehicleId() == vehicleId).findAny().get();
    }

    @Override
    public Vehicle updateVehicle(int vehicleId, Vehicle vehicle) {
        Vehicle updatedVehicle = null;
        // Surround with Try-Catch later down the road
        for(Vehicle v : vehicles) {
            if(v.getVehicleId() == vehicleId) {
                // update the object
                v.setModel(vehicle.getModel());
                v.setMake(vehicle.getMake());
                v.setYear(vehicle.getYear());
                updatedVehicle = v;
            }
        }
        return updatedVehicle;
    }

	@Override
	public void deleteVehicle(int vehicleId) {
        vehicles.removeIf(v -> v.getVehicleId() == vehicleId);
	}
}

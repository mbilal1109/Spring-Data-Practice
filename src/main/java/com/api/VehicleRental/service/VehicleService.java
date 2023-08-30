package com.api.VehicleRental.service;

import com.api.VehicleRental.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public Vehicle createVehicle(Vehicle vehicle);

    public List<Vehicle> getAllVehicles();

    public Vehicle getVehicle(int vehicleId);

    public Vehicle updateVehicle(int vehicleId, Vehicle vehicle);
    
    public void deleteVehicle(int vehicleId);
}

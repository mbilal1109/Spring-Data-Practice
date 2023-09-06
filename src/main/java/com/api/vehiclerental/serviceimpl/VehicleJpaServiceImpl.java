package com.api.vehiclerental.serviceimpl;

import com.api.vehiclerental.common.Constants;
import com.api.vehiclerental.dao.VehicleRepository;
import com.api.vehiclerental.model.Vehicle;
import com.api.vehiclerental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class VehicleJpaServiceImpl implements VehicleService {

    Logger logger = LoggerFactory.getLogger(VehicleJpaServiceImpl.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        logger.info("Vehicles: {}", vehicles);
        return vehicles;
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        Vehicle vehicleFound = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException(Constants.VEHICLE_NOT_FOUND));
        logger.info("Vehicle Found: {}", vehicleFound);
        return vehicleFound;
    }

    @Override
    public Vehicle updateVehicle(int vehicleId, Vehicle vehicle) {
        Vehicle newVehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException(Constants.VEHICLE_NOT_FOUND));
        newVehicle.setModel(vehicle.getModel());
        newVehicle.setMake(vehicle.getMake());
        newVehicle.setYear(vehicle.getYear());

        vehicleRepository.save(newVehicle);
        logger.info("Vehicle Updated: {}", newVehicle);
        return newVehicle;
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException(Constants.VEHICLE_NOT_FOUND));
        vehicleRepository.delete(vehicle);
        logger.info("Vehicle Deleted");
    }
}

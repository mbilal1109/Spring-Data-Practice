package com.api.vehiclerental.serviceimpl;

import com.api.vehiclerental.dao.VehicleDao;
import com.api.vehiclerental.model.Vehicle;
import com.api.vehiclerental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoVehicleServiceImpl implements VehicleService {

    private final Logger logger = LoggerFactory.getLogger(DaoVehicleServiceImpl.class);

    @Autowired
    private VehicleDao vehicleDao;

    public DaoVehicleServiceImpl(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleDao.saveVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        return vehicleDao.getSingleVehicle(vehicleId);
    }

    @Override
    public Vehicle updateVehicle(int vehicleId, Vehicle vehicle) {
        Vehicle newVehicle = vehicleDao.updateTodo(vehicleId, vehicle);
        logger.info("Vehicle Updated: {}", newVehicle);
        return newVehicle;
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        vehicleDao.deleteVehicle(vehicleId);
    }
}

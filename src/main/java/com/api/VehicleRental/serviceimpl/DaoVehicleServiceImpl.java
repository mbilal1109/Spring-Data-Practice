package com.api.VehicleRental.serviceimpl;

import com.api.VehicleRental.dao.VehicleDao;
import com.api.VehicleRental.model.Vehicle;
import com.api.VehicleRental.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoVehicleServiceImpl implements VehicleService {

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
        return vehicleDao.updateTodo(vehicleId, vehicle);
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        vehicleDao.deleteVehicle(vehicleId);
    }
}

package com.api.VehicleRental;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.api.VehicleRental.dao.VehicleDao;
import com.api.VehicleRental.model.Vehicle;

@SpringBootApplication
public class VehicleRentalApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(VehicleRentalApplication.class);

	@Autowired
	private VehicleDao vehicleDao;
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalApplication.class, args);
	}

	// For testing if JdbcTemplate is working correctly.
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application Started: ");
//		JdbcTemplate template = vehicleDao.getTemplate();
//		logger.info("Template Object: {}" , template.getDataSource().getConnection());
		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleId(8);
//		vehicle.setModel("Toyota");
//		vehicle.setMake("Corolla");
//		vehicle.setYear("2024");
//
//		vehicleDao.saveVehicle(vehicle);
		
//		vehicle.setModel("Toyota");
//		vehicle.setMake("Yaris");
//		vehicle.setYear("2024");
//		Vehicle newVehicle = vehicleDao.updateTodo(5, vehicle);
//		logger.info("Updated Vehicle: {}", newVehicle);
		
//		vehicleDao.deleteVehicle(8);
//
//		List<Vehicle> vehicles = vehicleDao.getAllVehicles();
//		logger.info("All Vehicles: {}", vehicles);
		
//		Vehicle vehicle = vehicleDao.getSingleVehicle(1);
	}
}

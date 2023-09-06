package com.api.vehiclerental;

import com.api.vehiclerental.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.vehiclerental.model.Vehicle;

@SpringBootApplication
public class VehicleRentalApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(VehicleRentalApplication.class);

	@Autowired
	private VehicleService vehicleService;
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalApplication.class, args);
	}

	// For testing if JPA is working correctly.
	@Override
	public void run(String... args) throws Exception {
		Vehicle v1 = new Vehicle();

//		v1.setModel("Tundra");
//		v1.setMake("Toyota");
//		v1.setYear("2024");
//
//		vehicleService.createVehicle(v1);

//		vehicleService.getVehicle(52);

//		v1.setModel("Integra");
//		v1.setMake("Acura");
//		v1.setYear("2023");
//		vehicleService.updateVehicle(302, v1);

//		vehicleService.getAllVehicles();

//		vehicleService.deleteVehicle(302);
//		vehicleService.getAllVehicles();
	}
}

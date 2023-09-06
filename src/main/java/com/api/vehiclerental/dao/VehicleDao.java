package com.api.vehiclerental.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.api.vehiclerental.model.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDao {
	
	Logger logger = LoggerFactory.getLogger(VehicleDao.class);
	
	private JdbcTemplate template;
	
	public VehicleDao(@Autowired JdbcTemplate template) {
		this.template = template;

		// Creating table if it doesn't exist in database
		String createTable = "create table IF NOT EXISTS vehicle(vehicleId int primary key, model varchar(100) not null, " +
				"make varchar(100) not null, year varchar(4) not null)";
		int update = template.update(createTable);
		logger.info("Vehicle Table Created {}", update);
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// save vehicle in database
	public Vehicle saveVehicle(Vehicle vehicle) {
		// Using ? to avoid sql injection.
		String insertQuery = "insert into vehicles(vehicleId, model, make, year) values(?,?,?,?)";
		int rows = template.update(insertQuery, vehicle.getVehicleId(), vehicle.getModel(), vehicle.getMake(),
				vehicle.getYear());
		logger.info("JDBC Operation: {}", rows);
		return vehicle;
	}
	
	// get single vehicle from database
	public Vehicle getSingleVehicle(int vehicleId) {
		String query = "select * from vehicles WHERE vehicleId = ?";
		Vehicle vehicle = template.queryForObject(query, new VehicleRowMapper(), vehicleId);
		logger.info("Vehicle: {}", vehicle);
		
		return vehicle;
	
//		Vehicle vehicle = new Vehicle();
//		
//		vehicle.setVehicleId(((int)vehicleData.get("vehicleId")));
//		vehicle.setModel(((String)vehicleData.get("model")));
//		vehicle.setMake(((String)vehicleData.get("make")));
//		vehicle.setYear(((String)vehicleData.get("year")));
//	
//		return vehicle;
	}
	
	// get all vehicle from database
	public List<Vehicle> getAllVehicles() {
		String query = "select * from vehicles";
		List<Vehicle> vehicles = template.query(query, new VehicleRowMapper());
		
		return vehicles;
		
//		List<Map<String, Object>> listMap = template.queryForList(query);
		
//		List<Vehicle> vehicles = listMap.stream().map((map) -> {
//			Vehicle vehicle = new Vehicle();
//			
//			vehicle.setVehicleId(((int)map.get("vehicleId")));
//			vehicle.setModel(((String)map.get("model")));
//			vehicle.setMake(((String)map.get("make")));
//			vehicle.setYear(((String)map.get("year")));
//		
//			return vehicle;
//		}).collect(Collectors.toList());
	}
	
	// update vehicle in database
	public Vehicle updateTodo(int vehicleId, Vehicle newVehicle) {
		String query = "update vehicles set model = ?, make = ?, year = ? WHERE vehicleId = ?";
		int rows = template.update(query, newVehicle.getModel(), newVehicle.getMake(), newVehicle.getYear(), vehicleId);
		logger.info("Updated: {}", rows);
		
		newVehicle.setVehicleId(vehicleId);
		return newVehicle;
	}
	
	// delete vehicle from database
	public void deleteVehicle(int vehicleId) {
		String query = "delete from vehicles WHERE vehicleId = ?";
		int rows = template.update(query, vehicleId);
		logger.info("Deleted Rows: {}", rows);
	}
}

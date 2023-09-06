package com.api.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.api.vehiclerental.model.Vehicle;

/*
 * For each row and maps the row of relations with 
 * the instances to the model(user-defined) class
 */
public class VehicleRowMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleId((rs.getInt("vehicleId")));
		vehicle.setModel((rs.getString("model")));
		vehicle.setMake((rs.getString("make")));
		vehicle.setYear((rs.getString("year")));

		return vehicle;
	}

}

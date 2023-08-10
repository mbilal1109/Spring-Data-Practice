package com.api.VehicleRental.model;

public class Vehicle {

    private int vehicleId;
    private String model;
    private String make;
    private String year;

    public Vehicle(int vehicleId, String model, String make, String year) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

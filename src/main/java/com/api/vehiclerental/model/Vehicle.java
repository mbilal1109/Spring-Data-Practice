package com.api.vehiclerental.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "vehicleId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(name = "model")
    private String model;

    @Column(name = "make")
    private String make;

    @Column(name = "year")
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

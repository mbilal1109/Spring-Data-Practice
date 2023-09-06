package com.api.vehiclerental.dao;

import com.api.vehiclerental.model.Vehicle;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}

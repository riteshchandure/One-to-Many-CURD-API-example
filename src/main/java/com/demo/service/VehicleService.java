package com.demo.service;

import java.util.List;

import com.demo.model.Vehicle;

public interface VehicleService {
	 List<Vehicle> getAllVehicles();
	 List<Vehicle> getVehiclesByUserId(Long userId);
	 Vehicle save(Vehicle vehicle);
}
 
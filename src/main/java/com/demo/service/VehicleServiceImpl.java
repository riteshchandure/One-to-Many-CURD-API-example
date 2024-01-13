package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.model.Vehicle;
import com.demo.repo.UserRepo;
import com.demo.repo.VehicleRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepo vr;
	
	@Autowired
	private UserRepo ur;
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return vr.findAll();
	}

	@Override
	public List<Vehicle> getVehiclesByUserId(Long userId) {
		User user = ur.findById(userId).orElse(null);
		if(user!=null)
			return vr.findByUser(user);
		return null;
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
				return vr.save(null);
	}

}

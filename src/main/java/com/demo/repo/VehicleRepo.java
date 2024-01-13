package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.User;
import com.demo.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByUser(User user);
	
}

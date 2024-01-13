package com.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Vehicle;
import com.demo.service.UserService;
import com.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin("*")
public class VehicleController {
	private VehicleService vehicleservice;
	
	private UserService userservice;
	
	public VehicleController(VehicleService vehicleservice, UserService userservice) {
		this.vehicleservice = vehicleservice;
		this.userservice = userservice;
	}
	
	@GetMapping()
	public ResponseEntity<List<Vehicle>> getAllVehicle(){
		return new ResponseEntity<>(this.vehicleservice.getAllVehicles(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Vehicle>> getVehiclesByUserId(@PathVariable Long id){
		return new ResponseEntity<>(this.vehicleservice.getVehiclesByUserId(id),HttpStatus.OK);
		
	}
	
	
	@PostMapping(value= "/{user_id}")
	public ResponseEntity<Vehicle> setVehicle(@PathVariable long user_id, @RequestBody Vehicle vehicle ){
		vehicle.setUser(userservice.getUserById(user_id));
		return new ResponseEntity<>(vehicleservice.save(vehicle),HttpStatus.OK);
	}
	
	@PutMapping("/{vehicleID}")
	public Vehicle updateVehicle(@PathVariable long vehicleID,@RequestBody Vehicle newVehicle){
		Vehicle oldVehicle = (Vehicle) vehicleservice.getVehiclesByUserId(vehicleID);
		if(oldVehicle == null) return null;
		oldVehicle.setName(newVehicle.getName());
		oldVehicle.setFeedback(newVehicle.getFeedback());
		return vehicleservice.save(oldVehicle);
	}
	;
}

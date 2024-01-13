package com.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController { 
	private UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(this.userservice.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		return new ResponseEntity<> (this.userservice.getUserById(id),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<User> setUsers(@RequestBody User user){
		return new ResponseEntity<>(userservice.save(user),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
		User oldUser = userservice.getUserById(id);
		if(oldUser == null) return null;
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		return new ResponseEntity<>(userservice.save(oldUser),HttpStatus.OK);
				
	}
	
	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable long id){
		userservice.deleteById(id);
		return "deleted";
	}
	
}

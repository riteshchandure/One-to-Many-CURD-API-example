package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo ur;
	
	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User save(User user) {
		return ur.save(user);
	}

	@Override
	public User getUserById(Long user_id) {
		return ur.findById(user_id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		User user = getUserById(id);
		ur.delete(user);
	}



}

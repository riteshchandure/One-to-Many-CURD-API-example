package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	List<User> getAllUsers();
	User save(User user);
	User getUserById(Long user_id);
	void deleteById(long id);
}


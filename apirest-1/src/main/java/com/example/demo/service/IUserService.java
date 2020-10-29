package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface IUserService {

	public List<User> findAll();
	
	public void save(User user);
	
	public User findUser(User user);
	
	public User checkUserLogin(User user);
	
	public void deleteUser(User user);
	
	public User updateUser(User user);
	
	public Optional<User> findUserById(Long user_id);
	
	public void deleteUser(Long id);
	
	public User findById(Long id);
	
	public User findByIdSQL(Long id);
	
	
	
}

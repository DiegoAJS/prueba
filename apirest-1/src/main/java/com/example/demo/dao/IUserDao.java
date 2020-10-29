package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface IUserDao extends CrudRepository<User,Long>  {
	
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
	
	public Optional<User> findById(Long id);
	
	@Query("SELECT u FROM user u WHERE u.id=?1" )
	public User findBySQL(Long id);
	
	

}

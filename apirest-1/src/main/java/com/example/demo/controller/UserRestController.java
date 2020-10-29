package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@PostMapping("sign_up")
	public ResponseEntity<Void> addUser(@RequestBody User user){
		if(userService.findUser(user)==null) {
			userService.save(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
}

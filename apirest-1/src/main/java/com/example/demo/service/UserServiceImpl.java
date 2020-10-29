package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findUser(User user) {
		return (User)userDao.findByEmail(user.getEmail());
	}

	@Override
	@Transactional(readOnly=true)
	public User checkUserLogin(User user) {
		return (User) userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDao.deleteById(user.getId());		
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return (User) userDao.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findUserById(Long user_id) {
		return (Optional<User>) userDao.findById(user_id);
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		userDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return (User) userDao.findById(id).orElse(null);
	}

	@Override
	public User findByIdSQL(Long id) {
		return userDao.findBySQL(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user); 
	}

}

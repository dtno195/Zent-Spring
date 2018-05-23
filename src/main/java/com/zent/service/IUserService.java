package com.zent.service;

import java.util.List;

import com.zent.entities.User;

public interface IUserService {
	public User findById(Long id);

	public void save(User user);

	public void update(User user);

	public void delete(Long id);
	
	public List<User> findAll();
}

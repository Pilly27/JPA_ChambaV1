package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.User;

import java.util.List;


public interface IUserService {
	public Integer insert(User user);
	public void insertUser(User user);
	public Integer buscarUser(String username);
	List<User> list();
	public Integer insertUserRol(Long user_id, Long rol_id);
	public Integer insertUserRol2(Long user_id, Long rol_id);

}

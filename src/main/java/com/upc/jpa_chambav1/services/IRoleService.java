package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.Role;

import java.util.List;



public interface IRoleService {
	public Role insert(Role role);

	List<Role> list();

}

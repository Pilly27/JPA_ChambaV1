package com.upc.jpa_chambav1.servicesimplements;

import com.upc.jpa_chambav1.entities.Role;
import com.upc.jpa_chambav1.repositories.RoleRepository;
import com.upc.jpa_chambav1.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleRepository rR;

	@Transactional
	@Override
	public Role insert(Role role) {
		return rR.save(role);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}

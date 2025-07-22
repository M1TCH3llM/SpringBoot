package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Role;
import com.synergisticit.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired RoleRepository  roleRepository;

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findRoleById(int roleId) {
		Optional<Role> optRole = roleRepository.findById(roleId);
		if( optRole.isPresent()) 
			return optRole.get();
		else
			return null;
	}

	@Override
	public List<Role> findRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role updateRoleById(int roleId) {
		Optional<Role> optRole = roleRepository.findById(roleId);
		if( optRole.isPresent()) {
			Role retrivedRole = optRole.get();
			return retrivedRole;
		}else {
			return null;
		}
	
	}

	@Override
	public void deleteRoleById(int roleId) {
		roleRepository.deleteById(roleId);

	}

}

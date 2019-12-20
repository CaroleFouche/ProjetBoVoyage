package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Role;

public interface IRoleService {

	
	public List<Role> getAllRole(); 
	
	public Role getRoleById(Role role);
	
	public Role addRole(Role role);
	
	public boolean deleteRole(Role role);
	
	public boolean updateRole(Role role);
}

package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Admin;


public interface IAdminService {

	public List<Admin> getAllAdmin(); 
	
	public Admin getAdminById(Admin admin);
	
	public Admin addAdmin(Admin admin);
	
	public boolean deleteAdmin(Admin admin);
	
	public boolean updateAdmin(Admin admin);
	

}

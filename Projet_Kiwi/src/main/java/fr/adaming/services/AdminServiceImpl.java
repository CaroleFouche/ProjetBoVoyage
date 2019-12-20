package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired 
	// Transformation de l'association UML en Java
	private IAdminDao adminDao;	
	
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAll();
	}

	@Override
	public Admin getAdminById(Admin admin) {
		return adminDao.getById(admin.getId());
	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminDao.add(admin);
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		Admin adminOut = adminDao.getById(admin.getId());
		if (adminOut!=null) {
			adminDao.delete(adminOut.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		Admin adminOut = adminDao.getById(admin.getId());
		
		if (adminOut!=null) {
			adminOut.setLogin(admin.getLogin());
			adminOut.setMdp(admin.getMdp());
			adminOut.setActive(admin.getActive());
			//Modifier l'admin dans le contexte
			adminDao.update(adminOut);
			return true;
		}
		return false;
	}

}

package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IRoleDao;
import fr.adaming.entities.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	public IRoleDao roleDao;

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> getAllRole() {
		return roleDao.getAll();
	}

	@Override
	public Role getRoleById(Role role) {
		return roleDao.getById(role.getId());
	}

	@Override
	public Role addRole(Role role) {
		return roleDao.add(role);
	}

	@Override
	public boolean deleteRole(Role role) {

		Role roleOut = roleDao.getById(role.getId());

		if (roleOut != null) {
			roleDao.delete(roleOut.getId());
			return true;
		}

		return false;
	}

	@Override
	public boolean updateRole(Role role) {
		Role roleOut = roleDao.getById(role.getId());

		if (roleOut != null) {
			roleOut.setName(role.getName());

			roleDao.update(roleOut);
			return true;
		}
		return false;
	}

}

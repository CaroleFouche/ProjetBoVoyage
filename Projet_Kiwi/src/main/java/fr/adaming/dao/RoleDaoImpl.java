package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.DossierClient;
import fr.adaming.entities.Hosting;
import fr.adaming.entities.Role;
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements IRoleDao{

	public RoleDaoImpl() {
		clazz = Role.class;
	}
}

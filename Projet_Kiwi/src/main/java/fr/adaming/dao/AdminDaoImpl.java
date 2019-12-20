package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Traveller;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements IAdminDao {
	public AdminDaoImpl() {
		clazz = Admin.class;
	}
}

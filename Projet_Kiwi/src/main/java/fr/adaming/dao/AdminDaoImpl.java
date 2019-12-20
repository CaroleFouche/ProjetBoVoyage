package fr.adaming.dao;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Traveller;

public class AdminDaoImpl extends GenericDaoImpl<Admin> implements IAdminDao {
	public AdminDaoImpl() {
		clazz = Admin.class;
	}
}

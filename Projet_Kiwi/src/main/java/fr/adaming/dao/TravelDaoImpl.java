package fr.adaming.dao;

import fr.adaming.entities.Role;
import fr.adaming.entities.Travel;

public class TravelDaoImpl extends GenericDaoImpl<Travel> implements ITravelDao {

	public TravelDaoImpl() {
		clazz = Travel.class;
	}
}

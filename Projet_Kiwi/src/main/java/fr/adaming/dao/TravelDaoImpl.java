package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Role;
import fr.adaming.entities.Travel;

@Repository
public class TravelDaoImpl extends GenericDaoImpl<Travel> implements ITravelDao {

	public TravelDaoImpl() {
		clazz = Travel.class;
	}
}

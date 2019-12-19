package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Traveller;

@Repository
public class TravellerDaoImpl extends GenericDaoImpl<Traveller> implements ITravellerDao {
	
	public TravellerDaoImpl() {
		clazz=Traveller.class;
	}

}

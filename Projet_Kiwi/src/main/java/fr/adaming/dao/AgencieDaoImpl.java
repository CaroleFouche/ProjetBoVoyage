package fr.adaming.dao;


import org.springframework.stereotype.Repository;

import fr.adaming.entities.Agencie;

@Repository
public class AgencieDaoImpl extends GenericDaoImpl<Agencie> implements IAgencieDao {
	public AgencieDaoImpl() {
		clazz = Agencie.class;
	}

	
	

}

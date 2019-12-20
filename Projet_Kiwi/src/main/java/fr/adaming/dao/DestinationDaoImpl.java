package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Destination;
@Repository
public class DestinationDaoImpl extends GenericDaoImpl<Destination> implements IDestinationDao {

	public DestinationDaoImpl() {
		clazz = Destination.class;
	}
}

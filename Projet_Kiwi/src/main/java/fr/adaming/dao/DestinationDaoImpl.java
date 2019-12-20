package fr.adaming.dao;

import fr.adaming.entities.Client;
import fr.adaming.entities.Destination;

public class DestinationDaoImpl extends GenericDaoImpl<Destination> implements IDestinationDao {

	public DestinationDaoImpl() {
		clazz = Destination.class;
	}
}

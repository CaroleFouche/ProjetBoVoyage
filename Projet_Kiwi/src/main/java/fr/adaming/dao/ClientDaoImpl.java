package fr.adaming.dao;

import fr.adaming.entities.Car;
import fr.adaming.entities.Client;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	public ClientDaoImpl() {
		clazz = Client.class;
	}
}

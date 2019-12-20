package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Car;
import fr.adaming.entities.Client;
@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {

	public ClientDaoImpl() {
		clazz = Client.class;
	}
}

package fr.adaming.dao;


import fr.adaming.entities.Client;

public interface IClientDao extends IGenericDao<Client>{
	public Client getByLogin(String login);
}

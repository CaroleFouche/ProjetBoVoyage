package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Car;
import fr.adaming.entities.Client;
@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao {
	
	@Autowired
	private SessionFactory sf;
	
	public ClientDaoImpl() {
		clazz = Client.class;
	}
	
	public Client getByLogin(String login) {
		
		Session s = sf.getCurrentSession();
		
		String requete = "FROM Client cl WHERE cl.login=:pLogin";

		Query queryOne = s.createQuery(requete);

		// Passage des parametres
		queryOne.setParameter("pLogin", login);

		// Recuperer le resultat
		Client clOut = (Client) queryOne.uniqueResult();
		
		return clOut;
		
	}
}

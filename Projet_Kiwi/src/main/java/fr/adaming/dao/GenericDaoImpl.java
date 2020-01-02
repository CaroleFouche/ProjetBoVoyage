package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDaoImpl<T> implements IGenericDao<T> {
	protected Class<T> clazz;

	@Autowired
	private SessionFactory sf;

	public Class<T> getClazz() {
		return clazz;
	}

	
	// cette methode pour specifier le vrai type de l'entity à utiliser (le vrai type T)
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	// le setter pour l'injection de dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<T> getAll() {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete HQL
		String req = "FROM " + clazz.getName();

		// creation d'un objet de type query
		Query query = s.createQuery(req);

		// envoyer la requete hql et recup de la liste puis la retiurner
		return query.list();
	}
	
	@Override
	public List<T> getFiltered(String keyword) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete HQL
		String req = "FROM " + clazz.getName() +" WHERE destination.pays LIKE ?";

		// creation d'un objet de type query
		Query query = s.createQuery(req);
		
		query.setString(0, "%"+keyword+"%");
		System.out.println("*************  :::  " + query);

		// envoyer la requete hql et recup de la liste puis la retiurner
		return query.list();
	}

	@Override
	public T getById(int id) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// recuperer l'objet de la bd par via la methode get de la sesison
		T t = (T) s.get(clazz, id);

		return t;
	}

	@Override
	public T add(T t) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// ajouter l'objet dans la bd via la methode save de la sesison
		s.save(t);
		
		
		return t;
	}

	@Override
	public T update(T t) {
		// recuperation de la session
		Session s = sf.getCurrentSession();
		
		// modifier l'objet dans la bd via la methode saveOrUpdate de la sesison
		// s.saveOrUpdate(t);
		s.merge(t);
		
		return t;
	}

	@Override
	public void delete(int id) {
		
		// recuperer l'objet de la bd par son id via la methode get de la sesison
		T t = this.getById(id);

		// recuperation de la session
		Session s = sf.getCurrentSession();
		// supprimer l'objet de la bd via la methode delete de la sesison
		s.delete(t);

	}

}

package fr.adaming.dao;

import java.util.List;

public interface IGenericDao<T> {
	
	//les methode generic
	public List<T> getAll();
	public T getById(int id);
	public T add(T t);
	public T update(T t);
	public void delete(int id);

}

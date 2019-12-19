package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Traveller;

@Repository
public class TravellerDaoImpl extends GenericDaoImpl<Traveller> implements ITravellerDao {
	//Ce constructeur permet de specifier le vrai type de l'entité a utiliser : ici Traveller
	public TravellerDaoImpl() {
		clazz=Traveller.class;
	}

}

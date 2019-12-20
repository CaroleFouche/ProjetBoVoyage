package fr.adaming.dao;

import fr.adaming.entities.Destination;
import fr.adaming.entities.DossierClient;

public class DossierClientDaoImpl extends GenericDaoImpl<DossierClient> implements IDossierClientDao {

	public DossierClientDaoImpl() {
		clazz = DossierClient.class;
	}
}

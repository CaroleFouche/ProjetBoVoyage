package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Destination;
import fr.adaming.entities.DossierClient;
@Repository
public class DossierClientDaoImpl extends GenericDaoImpl<DossierClient> implements IDossierClientDao {

	public DossierClientDaoImpl() {
		clazz = DossierClient.class;
	}
}

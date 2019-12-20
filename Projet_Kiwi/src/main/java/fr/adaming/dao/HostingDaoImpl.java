package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.DossierClient;
import fr.adaming.entities.Hosting;
@Repository
public class HostingDaoImpl extends GenericDaoImpl<Hosting> implements IHostingDao{

	public HostingDaoImpl() {
		clazz = Hosting.class;
	}
}

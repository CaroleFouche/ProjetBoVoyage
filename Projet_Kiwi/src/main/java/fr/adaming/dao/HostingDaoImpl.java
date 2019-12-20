package fr.adaming.dao;

import fr.adaming.entities.DossierClient;
import fr.adaming.entities.Hosting;

public class HostingDaoImpl extends GenericDaoImpl<Hosting> implements IHostingDao{

	public HostingDaoImpl() {
		clazz = Hosting.class;
	}
}

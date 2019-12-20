package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHostingDao;
import fr.adaming.entities.Hosting;

@Service
@Transactional
public class HostingServiceImpl implements IHostingService{

	// Transformation de l'association UML en Java
	private IHostingDao hDao;
	
	// Setter
	@Autowired
	public void setHDao(IHostingDao hDao) {
		this.hDao = hDao;
	}

	// Récupérer tous les hostings
	@Override
	public List<Hosting> getAllHosting() {
		return hDao.getAll();
	}

	@Override
	public Hosting getHostingById(Hosting hIn) {
		return hDao.getById(hIn.getId());
	}

	@Override
	public Hosting addHosting(Hosting hIn) {
		return hDao.add(hIn);
	}

	@Override
	public boolean deleteHosting(Hosting hIn) {
		Hosting hOut = hDao.getById(hIn.getId());
		if(hOut!=null) {
			hDao.delete(hOut.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHosting(Hosting hIn) {
		Hosting hOut = hDao.getById(hIn.getId());
		if(hOut!=null) {
			hOut.setName(hIn.getName());
			hOut.setArrivalDate(hIn.getArrivalDate());
			hOut.setLeavingDate(hIn.getLeavingDate());
			hOut.setCity(hIn.getCity());
			hOut.setPresta(hIn.getPresta());
			hDao.update(hOut);
			return true;
		}
		return false;
	}

}

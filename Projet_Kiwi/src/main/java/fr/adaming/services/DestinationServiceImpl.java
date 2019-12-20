package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.entities.Destination;

@Service
@Transactional
public class DestinationServiceImpl implements IDestinationService {
	@Autowired
	//Transfo de l'association UML en Java
	public IDestinationDao destiDao;
	
	public void setDestiDao(IDestinationDao destiDao) {
		this.destiDao = destiDao;
	}

	@Override
	public List<Destination> getAllDestination() {
		return destiDao.getAll();
	}

	@Override
	public Destination getDestinationById(Destination destination) {
		return destiDao.getById(destination.getId());
	}

	@Override
	public Destination addDestination(Destination destination) {
		return destiDao.add(destination);
	}

	@Override
	public boolean deleteDestination(Destination destination) {
		
		Destination destiOut = destiDao.getById(destination.getId());
		
		if (destiOut!=null) {
			destiDao.delete(destiOut.getId());
			return true;
		}		
		return false;
	}

	@Override
	public boolean updateDestination(Destination destination) {
		
		Destination destiOut = destiDao.getById(destination.getId());
		
		if(destiOut!=null) {
			destiOut.setContinent(destination.getContinent());
			destiOut.setPays(destination.getPays());
			destiOut.setTravel(destination.getTravel());
	
			destiDao.update(destiOut);
			return true;
		}
		
		return false;
	}
	

}

package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ITravelDao;
import fr.adaming.entities.Travel;

@Service
@Transactional
public class TravelServiceImpl implements ITravelService {

	// Transformation de l'association UML en JAVA
	public ITravelDao tDao;

	@Autowired
	public void settDao(ITravelDao tDao) {
		this.tDao = tDao;
	}

	@Override
	public List<Travel> getAllTravel() {

		return tDao.getAll();
	}

	@Override
	public Travel getTravelById(Travel tIn) {
		return tDao.getById(tIn.getId());
	}

	@Override
	public Travel addTravel(Travel tIn) {
		return tDao.add(tIn);
	}

	@Override
	public boolean deleteTravel(Travel tIn) {
		Travel tOut = tDao.getById(tIn.getId());
		if (tOut != null) {
			tDao.delete(tOut.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTravel(Travel tIn) {
		Travel tOut = tDao.getById(tIn.getId());
		if (tOut != null) {
			tOut.setBooking(tIn.getBooking());
			tOut.setCar(tIn.getCar());
			tOut.setDestination(tIn.getDestination());
			tOut.setEndDate(tIn.getEndDate());
			tOut.setHostings(tIn.getHostings());
			tOut.setPic(tIn.getPic());
			tOut.setPrice(tIn.getPrice());
			tOut.setStartDate(tIn.getStartDate());
			tOut.setAvailability(tIn.isAvailability());
			tDao.update(tOut);
			return true;
		} else {
			return false;
		}
	}

}

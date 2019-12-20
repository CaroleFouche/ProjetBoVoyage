package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ITravellerDao;
import fr.adaming.entities.Traveller;

@Service
@Transactional
public class TravellerServiceImpl implements ITravellerService {

	// transformation de l'association UML en java
	private ITravellerDao trDao;

	// Setter + annotation
	@Autowired
	public void setTrDao(ITravellerDao trDao) {
		this.trDao = trDao;
	}

	@Override
	public List<Traveller> getAllTraveller() {
		return trDao.getAll();
	}

	@Override
	public Traveller getTravellerById(Traveller tIn) {
		return trDao.getById(tIn.getId());
	}

	@Override
	public Traveller addTraveller(Traveller tIn) {
		return trDao.add(tIn);
	}

	@Override
	public boolean deleteTraveller(Traveller tIn) {
		Traveller tOut = trDao.getById(tIn.getId());
		if (tOut != null) {
			trDao.delete(tOut.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTraveller(Traveller tIn) {
		Traveller tOut = trDao.getById(tIn.getId());
		if (tOut != null) {
			tOut.setAge(tIn.getAge());
			tOut.setBooking(tIn.getBooking());
			tOut.setMail(tIn.getMail());
			tOut.setName(tIn.getName());
			tOut.setPhone(tIn.getPhone());
			trDao.update(tOut);
			return true;
		} else {
			return false;
		}
	}

}

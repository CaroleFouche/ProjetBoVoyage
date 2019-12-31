package fr.adaming.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDestinationDao;
import fr.adaming.dao.ITravelDao;
import fr.adaming.entities.Destination;
import fr.adaming.entities.Image;
import fr.adaming.entities.Travel;

@Service
@Transactional
public class TravelServiceImpl implements ITravelService {

	// Transformation de l'association UML en JAVA
	public ITravelDao tDao;
	public IDestinationDao destiDao;

	@Autowired
	public void settDao(ITravelDao tDao) {
		this.tDao = tDao;
	}

	@Override
	public List<Travel> getAllTravel() {
		List<Travel> liste = tDao.getAll();
		for (Travel t : liste) {
			if(t.getDestination() == null) {
				continue;
			}
			for (Image img : t.getDestination().getPics()) {
				img.setPhotoString("data:image/jpeg;base64,"+Base64.encodeBase64String(img.getPhoto()));
			}
		}

		return liste;
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
			tOut.setBookings(tIn.getBookings());
			tOut.setCar(tIn.getCar());
			tOut.setDestination(tIn.getDestination());
			tOut.setEndDate(tIn.getEndDate());
			tOut.setHostings(tIn.getHostings());
			tOut.setPrice(tIn.getPrice());
			tOut.setStartDate(tIn.getStartDate());
			tOut.setAvailability(tIn.isAvailability());
			tDao.update(tOut);
			return true;
		} else {
			return false;
		}
	}

	//Recuperer la liste des voyages disponibles
	public List<Travel> areAvailable(){
		// Recupere la liste de voyages
		List<Travel> listTravel = getAllTravel();
		// On parcourt la liste des voyages et on selectionne seulement les voyages
		// disponibles que l'on stock dans listeAffichage
		List<Travel> listeAvailable = new ArrayList<Travel>();
		for (Travel travel : listTravel) {
			if (travel.isAvailability()) {
				listeAvailable.add(travel);
			}
		}
		return listeAvailable;
	}
	
}

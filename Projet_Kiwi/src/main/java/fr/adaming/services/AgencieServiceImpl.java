package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgencieDao;
import fr.adaming.entities.Agencie;

@Service
@Transactional
public class AgencieServiceImpl implements IAgencieService {

	@Autowired
	public IAgencieDao agencieDao;

	public void setAgencieDao(IAgencieDao agencieDao) {
		this.agencieDao = agencieDao;
	}

	@Override
	public List<Agencie> getAllAgencie() {
		return agencieDao.getAll();
	}

	@Override
	public Agencie getAgencieById(Agencie agence) {
		return agencieDao.getById(agence.getId());
	}

	@Override
	public Agencie addAgencie(Agencie agence) {
		return agencieDao.add(agence);
	}

	@Override
	public boolean deleteAgencie(Agencie agence) {
		Agencie agOut = agencieDao.getById(agence.getId());
		if (agOut != null) {
			agencieDao.delete(agOut.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAgencie(Agencie agence) {
		Agencie agOut = agencieDao.getById(agence.getId());
		if (agOut != null) {
			agOut.setListAdmin(agence.getListAdmin());
			agOut.setLocalisation(agence.getLocalisation());
			agOut.setName(agence.getName());
			agOut.setPhoneNumber(agence.getPhoneNumber());
			agencieDao.update(agOut);
			return true;
		}
		return false;
	}

}

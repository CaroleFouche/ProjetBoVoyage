package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierClientDao;
import fr.adaming.entities.DossierClient;

@Service
@Transactional
public class DossierClientServiceImpl implements IDossierClientService {

	// Transformation de l'association UML en JAVA
	public IDossierClientDao dcDao;

	@Autowired
	public void setDcDao(IDossierClientDao dcDao) {
		this.dcDao = dcDao;
	}

	@Override
	public List<DossierClient> getAllDossierClient() {

		return dcDao.getAll();
	}

	@Override
	public DossierClient getDossierClientById(DossierClient dcIn) {
		return dcDao.getById(dcIn.getId());
	}

	@Override
	public DossierClient addDossierClient(DossierClient dcIn) {

		return dcDao.add(dcIn);
	}

	@Override
	public boolean deleteDossierClient(DossierClient dcIn) {
		DossierClient dcOut = dcDao.getById(dcIn.getId());
		if (dcOut != null) {
			dcDao.delete(dcOut.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateDossierClient(DossierClient dcIn) {
		DossierClient dcOut = dcDao.getById(dcIn.getId());
		if (dcOut != null) {
			dcOut.setClient(dcOut.getClient());
			dcDao.update(dcOut);
			return true;
		} else {
			return false;
		}
	}

}

package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	// Transformation de l'association UML en Java
	private IClientDao clDao;

	// Setter
	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	// Récupérer tous les clients
	@Override
	public List<Client> getAllClient() {
		return clDao.getAll();
	}

	// Récupérer un client par son Id
	@Override
	public Client getClientById(Client clIn) {
		return clDao.getById(clIn.getId());
	}

	// Ajouter un client
	@Override
	public Client addClient(Client clIn) {
		return clDao.add(clIn);
	}

	// Supprimer un client
	@Override
	public boolean deleteClient(Client clIn) {
		Client clOut = clDao.getById(clIn.getId());
		if (clOut != null) {
			clDao.delete(clOut.getId());
			return true;
		}
		return false;
	}

	// Modifier un client
	@Override
	public boolean updateClient(Client clIn) {
		Client clOut = clDao.getById(clIn.getId());
		if (clOut != null) {
			clOut.setName(clIn.getName());
			clOut.setPhone(clIn.getPhone());
			clOut.setMail(clIn.getMail());
			clOut.setAge(clIn.getAge());
			clOut.setBooking(clIn.getBooking());
			clOut.setNumCard(clIn.getNumCard());
			clOut.setSolvability(clIn.isSolvability());
			clOut.setLogin(clIn.getLogin());
			clOut.setMdp(clIn.getMdp());
			clOut.setActive(clIn.getActive());
			clDao.update(clOut);
			return true;
		}
		return false;
	}

}

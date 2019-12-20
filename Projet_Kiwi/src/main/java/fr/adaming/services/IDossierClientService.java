package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.DossierClient;

public interface IDossierClientService {

	public List<DossierClient> getAllDossierClient();

	public DossierClient getDossierClientById(DossierClient tIn);

	public DossierClient addDossierClient(DossierClient tIn);

	public boolean deleteDossierClient(DossierClient tIn);

	public boolean updateDossierClient(DossierClient tIn);
}

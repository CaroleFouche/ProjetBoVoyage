package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Agencie;

public interface IAgencieService {
	public List<Agencie> getAllAgencie(); 
	
	public Agencie getAgencieById(Agencie agence);
	
	public Agencie addAgencie(Agencie agence);
	
	public boolean deleteAgencie(Agencie agence);
	
	public boolean updateAgencie(Agencie agence);
}

package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Traveller;

public interface ITravellerService {

	public List<Traveller> getAllTraveller();

	public Traveller getTravellerById(Traveller tIn);

	public Traveller addTraveller(Traveller tIn);

	public boolean deleteTraveller(Traveller tIn);

	public boolean updateTraveller(Traveller tIn);
}

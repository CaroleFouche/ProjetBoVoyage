package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Travel;


public interface ITravelService {

	public List<Travel> getAllTravel();

	public Travel getTravelById(Travel tIn);

	public Travel addTravel(Travel tIn);

	public boolean deleteTravel(Travel tIn);

	public boolean updateTravel(Travel tIn);
}

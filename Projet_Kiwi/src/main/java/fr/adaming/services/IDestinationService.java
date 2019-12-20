package fr.adaming.services;

import java.util.List;


import fr.adaming.entities.Destination;

public interface IDestinationService {

	public List<Destination> getAllDestination(); 
	
	public Destination getDestinationById(Destination destination);
	
	public Destination addDestination(Destination destination);
	
	public boolean deleteDestination(Destination destination);
	
	public boolean updateDestination(Destination destination);
	
	
}

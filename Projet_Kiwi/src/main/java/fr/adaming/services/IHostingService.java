package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Hosting;

public interface IHostingService {
	
	public List<Hosting> getAllHosting();
	
	public Hosting getHostingById(Hosting hIn);
	
	public Hosting addHosting(Hosting hIn);
	
	public boolean deleteHosting(Hosting hIn);
	
	public boolean updateHosting(Hosting hIn);

}

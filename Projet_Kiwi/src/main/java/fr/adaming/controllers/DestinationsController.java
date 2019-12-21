package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Destination;
import fr.adaming.services.IDestinationService;

@Controller
@RequestMapping("/destinations")
public class DestinationsController {
	
	
	@Autowired
	private IDestinationService destinationService;
	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}


	@RequestMapping(method=RequestMethod.GET)
	public String getIndex(Model modelDestinations) {
		
		List<Destination> l = destinationService.getAllDestination();
		
		modelDestinations.addAttribute("list", l);
		
		return "public/destinations";
	}
	
	
	/*
	 *		Get ALL dest (TO BE FINISHED)
	 *
	 */
	@RequestMapping(value="all", method=RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		
		List<Destination> l = destinationService.getAllDestination();
		
		modelDestinations.addAttribute("list", l);
		
		return "public/destinations";
	}
	@RequestMapping(value="all", method=RequestMethod.POST)
	public String onPost(Model m, @ModelAttribute Destination dm) {
		
		return "public/destinations";
	}
	
	
	
	
	
	
	
	
}
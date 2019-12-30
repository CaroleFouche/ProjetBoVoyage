package fr.adaming.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Travel;
import fr.adaming.services.ITravelService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	// Declaration de l'association UML en JAVA
	@Autowired
	public ITravelService travelService;
	// Setter pour l'injection de dependance
	public void setTravelService(ITravelService travelService) {
		this.travelService = travelService;
	}

	//Méthode pour afficher tous les voyages disponibles
	@RequestMapping(method = RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		List<Travel> listTravel = travelService.areAvailable();
		modelDestinations.addAttribute("listTravels", listTravel);
		return "home";
	}
	
}

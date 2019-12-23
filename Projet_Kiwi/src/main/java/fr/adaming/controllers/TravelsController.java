package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Travel;
import fr.adaming.services.ITravelService;

@Controller
@RequestMapping("/travels")
public class TravelsController {

	// Declaration de l'association UML en JAVA
	@Autowired
	public ITravelService travelService;

	// Setter pour l'injection de dependance
	public void setTravelService(ITravelService travelService) {
		this.travelService = travelService;
	}

	//M�thode pour afficher tous les voyages disponibles
	@RequestMapping(method = RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		List<Travel> listTravel = travelService.areAvailable();
		modelDestinations.addAttribute("listTravels", listTravel);
		return "public/travels";
	}

}
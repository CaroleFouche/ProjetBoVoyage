package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.Agencie;
import fr.adaming.services.IAgencieService;

@Controller
@RequestMapping(value="/agencies")
public class AgenciesController {
	
	@Autowired
	public IAgencieService agencieService;	
	public void setAgencieService(IAgencieService agencieService) {
		this.agencieService = agencieService;
	}
	
	//Afficher toutes les agences
	@RequestMapping(method=RequestMethod.GET)
	public String getAllDestinations( Model model) {
		List<Agencie> listAgencies = agencieService.getAllAgencie();
		model.addAttribute("listAgences", listAgencies);
		return "public/agencies";
	}
	
	//Afficher les informations d'une agence
	@RequestMapping(value="details", method=RequestMethod.GET)
		public String afficherAgence(Model model, @RequestParam("pId") int id) {
		Agencie agence = new Agencie();
		agence.setId(id);		
		Agencie agOut = agencieService.getAgencieById(agence);
		model.addAttribute("agence", agOut);	
		return "public/agencieDetails";
	}
		
}

package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Agencie;
import fr.adaming.entities.Travel;
import fr.adaming.services.AgencieServiceImpl;
import fr.adaming.services.IAgencieService;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminAgenciesController {
	
	@Autowired
	public IAgencieService agencieService;	
	public void setAgencieService(IAgencieService agencieService) {
		this.agencieService = agencieService;
	}


	@RequestMapping(value= {"agencies"}, method=RequestMethod.GET)
	public String getAllDestinations(Model model) {
		List<Agencie> listAgencies = agencieService.getAllAgencie();
		model.addAttribute("listAgences", listAgencies);
		return "admin/adminAgencies";
	}
	
	// ------------Fonctionnalité: Ajouter agence -------------------
		// Affichage du formulaire
		@RequestMapping(value = "addAgencie", method = RequestMethod.GET)
		public ModelAndView afficherAdd() {
			return new ModelAndView("admin/addAgencie", "agencie", new Agencie());
		}

		// Recuperation des données du form dans agencie
		@RequestMapping(value = "submitAddAgencie", method = RequestMethod.POST)
		public String submitAdd(RedirectAttributes rda, Model modele, @ModelAttribute("agencie") Agencie a) {
			Agencie agOut = agencieService.addAgencie(a);
			if (agOut != null) {
				modele.addAttribute("agencie", agOut);
				return "redirect:agencies";
			} else {
				rda.addFlashAttribute("msg", "L'agence n'a pas été ajouté");
				return "redirect:submitAddAgencie";
			}
		}
		
		// ---------------Fonctionnalité: Modifier agence ------------------
		// Affichage du formulaire
		@RequestMapping(value = "updateAgencie", method = RequestMethod.GET)
		public ModelAndView afficherUpdate() {
			return new ModelAndView("admin/updateAgencie", "agencie", new Agencie());
		}
		// Recuperation des données du form dans agencie
		@RequestMapping(value = "submitUpdateAgencie", method = RequestMethod.POST)
		public String submitUpdate(RedirectAttributes rda, Model modele, @ModelAttribute("agencie") Agencie agence) {
			boolean verif = agencieService.updateAgencie(agence);
			if (verif) {
				return "redirect:agencies";
			} else {
				rda.addFlashAttribute("msgechec", "L'agence n'a pas été modifié");
				return "redirect:submitUpdateAgencie";
			}
		}
		//Pour injecter les valeurs de l'agence a modifier depuis la page d'accueil
		@RequestMapping(value = "linkedUpdateAgence", method = RequestMethod.GET)
		public String updateLinked(Model modele, @RequestParam("pId") int id) {
			Agencie ag = new Agencie();
			ag.setId(id);
			Agencie agOut = agencieService.getAgencieById(ag);
			modele.addAttribute("agencie", agOut);
			return "admin/updateAgencie";
		}

		// --------------Fonctionnalité : Supprimer voyage -------------------
		//Supprimer le Travel depuis la page d'accueil
		@RequestMapping(value = "submitDeleteAgencie", method = RequestMethod.GET)
		public String submitDelete(RedirectAttributes rda, Model model, @RequestParam("pId") int id) {
			Agencie ag = new Agencie();
			ag.setId(id);
			Agencie agOut= agencieService.getAgencieById(ag);
			boolean verif = agencieService.deleteAgencie(agOut);
			if (verif) {
				return "redirect:agencies";
			}else {
				rda.addFlashAttribute("msg", "Erreur");
				return "redirect:agencies";
			}

		}
	
}

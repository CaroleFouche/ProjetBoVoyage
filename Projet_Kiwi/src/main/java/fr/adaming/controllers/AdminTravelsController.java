package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Travel;
import fr.adaming.services.ITravelService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminTravelsController {
	// Declaration de l'association UML en JAVA
	@Autowired
	public ITravelService travelService;

	// Setter pour l'injection de dependance
	public void setTravelService(ITravelService travelService) {
		this.travelService = travelService;
	}

	// La méthode appelée pour convertir les valeurs des parametres de la requete en
	// objet java(par ex: Date)
	@InitBinder // Pour quelle soit appelée lors de la conversion
	public void initBinder(WebDataBinder binder) {
		// l'objet WebDataBinder sert a faire le lien entre les params de la requete et
		// les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		// la methode register custom editor: a configurer la conversion du param recu
		// au type de l'attribut
		// L'objet customdateeditor : sert a lier la date recu comme param de la requete
		// a l'attribut de l'objet
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// Afficher la liste de tous les voyages
	@RequestMapping(value = { "travels" }, method = RequestMethod.GET)
	public String getAllDestinations(Model modelTravels) {
		List<Travel> listTravel = travelService.getAllTravel();
		modelTravels.addAttribute("listTravels", listTravel);
		return "admin/adminTravels";
	}

	// ------------Fonctionnalité: Ajouter voyage -------------------
	// Affichage du formulaire
	@RequestMapping(value = "addTravel", method = RequestMethod.GET)
	public ModelAndView afficherAdd() {
		return new ModelAndView("admin/addTravel", "travel", new Travel());
	}

	// Recuperation des données du form dans travel
	@RequestMapping(value = "submitAddTravel", method = RequestMethod.POST)
	public String submitAdd(RedirectAttributes rda, Model modele, @ModelAttribute("travel") Travel t) {
		Travel tOut = travelService.addTravel(t);
		if (tOut != null) {
			modele.addAttribute("travel", tOut);
			return "redirect:travels";
		} else {
			rda.addFlashAttribute("msg", "Le voyage n'a pas été ajouté");
			return "redirect:submitAddTravel";
		}
	}

	// ------------Fonctionnalité : Modifier voyage ------------------
	// Affichage du formulaire
	@RequestMapping(value = "updateTravel", method = RequestMethod.GET)
	public ModelAndView afficherUpdate() {
		return new ModelAndView("admin/updateTravel", "travel", new Travel());
	}
	// Recuperation des données du form dans travel
	@RequestMapping(value = "submitUpdateTravel", method = RequestMethod.POST)
	public String submitUpdate(RedirectAttributes rda, Model modele, @ModelAttribute("travel") Travel t) {
		boolean verif = travelService.updateTravel(t);
		if (verif) {
			return "redirect:travels";
		} else {
			rda.addFlashAttribute("msgechec", "Le voyage n'a pas été modifié");
			return "redirect:submitUpdateTravel";
		}
	}
	//Pour injecter les valeurs du Travel a modifier depuis la page d'accueil
	@RequestMapping(value = "linkedUpdateTravel", method = RequestMethod.GET)
	public String updateLinked(Model modele, @RequestParam("pId") int id) {
		Travel t = new Travel();
		t.setId(id);
		Travel tOut = travelService.getTravelById(t);
		modele.addAttribute("travel", tOut);
		return "admin/updateTravel";
	}

	// --------------Fonctionnalité : Supprimer voyage -------------------
	//Supprimer le Travel depuis la page d'accueil
	@RequestMapping(value = "submitDeleteTravel", method = RequestMethod.GET)
	public String submitDelete(RedirectAttributes rda, Model model, @RequestParam("pId") int id) {
		Travel t = new Travel();
		t.setId(id);
		Travel tOut = travelService.getTravelById(t);
		boolean verif = travelService.deleteTravel(tOut);
		if (verif) {
			return "redirect:travels";
		}else {
			rda.addFlashAttribute("msg", "Erreur");
			return "redirect:travels";
		}

	}

}

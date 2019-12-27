package fr.adaming.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Client;
import fr.adaming.entities.Formula;
import fr.adaming.entities.Status;
import fr.adaming.services.IClientService;

@Controller
@RequestMapping(value = { "/user" })
public class UserDashboardController {

	@Autowired
	public IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// Afficher les infos client
	@RequestMapping(value = { "dashboard" }, method = RequestMethod.GET)
	public String getClient(Model model) {

		//Recupere un object de type UserDetails qui stocke les infos du client connecté
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Client clIn = new Client();
		//On stock dans un nouveau client le login du client connecté
		clIn.setLogin(userDetails.getUsername());
		//On recupere le client stocké dans la BD (avec son ID)
		Client cl = clientService.getByLogin(clIn);

//		if (cl == null || cl.getId() == 0) {
//			cl = new Client();
//			cl.setId(1);
//			// on ajoute le client passé en brut dans la BD pour pouvoir s'en reservir dans
//			// update
//			clientService.addClient(cl);
//		}

		// On l'envoi dans le model
		model.addAttribute("logedClient", cl);
		return "user/dashboard";
	}

//	@RequestMapping(value = { "dashboard" }, method = RequestMethod.GET)
//	public String getAllDestinations(Model modelDestinations) {
//		return "user/dashboard";
//	}

	/*
	 * Modifier Client
	 */

	@RequestMapping(value = { "updateClient" }, method = RequestMethod.GET)
	public ModelAndView afficherUpdate(@RequestParam(value = "pId", required = false) Integer id,
			@ModelAttribute("client") Client cl) {

		if (cl == null) {
			cl = new Client();
		}
		// if client is specified by id, set id
		if (id != null) {
			cl.setId(id);
			cl = clientService.getClientById(cl);
		}
		return new ModelAndView("user/updateClient", "client", cl);
	}

	@RequestMapping(value = { "updateClient" }, method = RequestMethod.POST)
	public String submitUpdate(RedirectAttributes rda, Model model, @ModelAttribute("client") Client cl) {

		// data validation
		if (cl == null || cl.getId() == 0) {

			rda.addFlashAttribute("errorMsg", "ID incorrect");
			rda.addFlashAttribute("errorMsg", cl.getId());
			rda.addFlashAttribute("client", cl);
			return "redirect:updateClient";
		}

		// update
		boolean result = clientService.updateClient(cl);
		System.out.println("POST updtae cl");

		// si client modifié redirige sur l'acceuil
		if (result == true) {
			rda.addFlashAttribute("successMsg", "Informations modifiées");
			return "redirect:dashboard";

			// si client pas modifié redirige sur le formulaire d'ajout
		} else {
			rda.addFlashAttribute("errorMsg", "La modification n'a pas été effectuée");
			rda.addFlashAttribute("client", cl);
			return "redirect:updateClient";
		}

	}

	@RequestMapping(value = { "myReservations" }, method = RequestMethod.GET)
	public ModelAndView getReservations(Model model, @RequestParam(value = "pId", required = false) Integer id,
			@ModelAttribute("client") Client cl) {
		System.out.println(id);
		if (cl == null) {
			cl = new Client();
		}
		if (id != null) {
			cl.setId(id);
			cl = clientService.getClientById(cl);
		}
		List<Booking> l = cl.getBookings();
		model.addAttribute("listBooking", l);
		return new ModelAndView("user/myReservations", "client", cl);
	}

}

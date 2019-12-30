package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Agencie;
import fr.adaming.entities.Booking;
import fr.adaming.entities.Client;
import fr.adaming.entities.Status;
import fr.adaming.services.IAgencieService;
import fr.adaming.services.IBookingService;
import fr.adaming.services.IClientService;

@Controller
@RequestMapping(value = { "/user" })
public class UserPayController {

	@Autowired
	public IBookingService bookingService;

	public void setBookingService(IBookingService bookingService) {
		this.bookingService = bookingService;

	}

	@Autowired
	public IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = { "payBooking" }, method = RequestMethod.GET)
	public ModelAndView payBooking(Model model, @RequestParam("pId") int id) {
		Booking b = new Booking();
		b.setId(id);
		b = bookingService.getBookingById(b);
		b.setStatus(Status.accepte);
		bookingService.updateBooking(b);

		// Recupere un object de type UserDetails qui stocke les infos du client
		// connecté
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Client clIn = new Client();
		// On stock dans un nouveau client le login du client connecté
		clIn.setLogin(userDetails.getUsername());
		// On recupere le client stocké dans la BD (avec son ID)
		Client cl = clientService.getByLogin(clIn);

//				if (cl == null || cl.getId() == 0) {
//					cl = new Client();
//					cl.setId(1);
//					// on ajoute le client passé en brut dans la BD pour pouvoir s'en reservir dans
//					// update
//					clientService.addClient(cl);
//				}

		List<Booking> l = cl.getBookings();
		model.addAttribute("listBooking", l);
		model.addAttribute("cl", cl);
		return new ModelAndView("user/myReservations", "client", cl);
	}

	@RequestMapping(value = { "delBooking" }, method = RequestMethod.GET)
	public ModelAndView deleteBooking(Model model, @RequestParam("pId") int id) {

		Booking b = new Booking();
		b.setId(id);
		b = bookingService.getBookingById(b);
		bookingService.deleteBooking(b);
		// Recupere un object de type UserDetails qui stocke les infos du client
		// connecté
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Client clIn = new Client();
		// On stock dans un nouveau client le login du client connecté
		clIn.setLogin(userDetails.getUsername());
		// On recupere le client stocké dans la BD (avec son ID)
		Client cl = clientService.getByLogin(clIn);

//						if (cl == null || cl.getId() == 0) {
//							cl = new Client();
//							cl.setId(1);
//							// on ajoute le client passé en brut dans la BD pour pouvoir s'en reservir dans
//							// update
//							clientService.addClient(cl);
//						}

		// On l'envoi dans le model
		List<Booking> l = cl.getBookings();
		model.addAttribute("listBooking", l);
		model.addAttribute("cl", cl);
		return new ModelAndView("user/myReservations", "client", cl);
	}

}

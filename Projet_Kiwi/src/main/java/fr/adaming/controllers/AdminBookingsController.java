package fr.adaming.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Booking;

import fr.adaming.entities.Formula;
import fr.adaming.entities.Status;
import fr.adaming.services.IBookingService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminBookingsController {

	@Autowired
	public IBookingService bookingService;

	public void setBookingService(IBookingService bookingService) {
		this.bookingService = bookingService;
	}

	/*
	 * page principale : afficher toutes les reservations
	 */

	@RequestMapping(value = { "bookings" }, method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Booking> b = bookingService.getAllBooking();
		model.addAttribute("listBookings", b);
		return "admin/adminBookings";
	}

	/*
	 * Ajouter une reservation
	 */

	@RequestMapping(value = { "addBooking" }, method = RequestMethod.GET)
	public ModelAndView afficherAdd(@ModelAttribute("booking") Booking b) {

		// b can be passed by POST if addBooking has failed. avoid to rewrite b params.
		if (b == null) {
			b = new Booking();
		}
		// On passe une map des enums pour les afficher dans le select
		ModelAndView mav = new ModelAndView("admin/addBooking", "booking", b);
		Map<Formula, String> formulas = new HashMap<Formula, String>();
		formulas.put(Formula.avion, Formula.avion.getDisplayName());
		formulas.put(Formula.avionHotel, Formula.avionHotel.getDisplayName());
		formulas.put(Formula.avionHotelVoiture, Formula.avionHotelVoiture.getDisplayName());
		formulas.put(Formula.avionVoiture, Formula.avionVoiture.getDisplayName());

		Map<Status, String> status = new HashMap<Status, String>();
		status.put(Status.accepte, Status.accepte.getDisplayName());
		status.put(Status.enAttente, Status.enAttente.getDisplayName());
		status.put(Status.enCours, Status.enCours.getDisplayName());
		status.put(Status.refuse, Status.refuse.getDisplayName());

		mav.addObject("enumFormula", formulas);
		mav.addObject("enumStatus", status);
		return mav;
	}

	@RequestMapping(value = { "submitAddBooking" }, method = RequestMethod.POST)
	public String submitAdd(RedirectAttributes rda, Model model, @ModelAttribute("booking") Booking b) {
		Booking bOut = bookingService.addBooking(b);
		// si resa ajout� rtedirige sur l'acceuil
		if (bOut != null) {
			rda.addFlashAttribute("successMsg", "Reservation ajout�e");
			return "redirect:bookings";
		} else { // si resa pas ajout� redirige sur le formulaire d'ajout
			rda.addFlashAttribute("errorMsg", "La r�servation n'a pas �t� ajout�");
			rda.addFlashAttribute("booking", b);
			return "redirect:addBooking";
		}
	}

	/*
	 * Supprimer une r�sa
	 */
	@RequestMapping(value = { "deleteBooking" }, method = RequestMethod.GET)
	public String onDeletePost(RedirectAttributes rda, Model model, @RequestParam("pId") int id) {

		// si id inconnu
		if (id == 0) {
			rda.addFlashAttribute("errorMsg", "Id r�sa inconnu");
			return "redirect:bookings";
		}

		// recupere la reservation correspondant a l'id et le supprime
		Booking b = new Booking();
		b.setId(id);
		boolean result = bookingService.deleteBooking(b);

		if (result == true) {
			rda.addFlashAttribute("successMsg", "R�servation supprim�e");
		} else {
			rda.addFlashAttribute("errorMsg", "La reservation n'a pas �t� supprim�");
		}
		return "redirect:bookings";
	}

	/*
	 * Modifier une reservation
	 */

	@RequestMapping(value = { "updateBooking" }, method = RequestMethod.GET)
	public ModelAndView afficherUpdate(@RequestParam(value = "pId", required = false) Integer id,
			@ModelAttribute("booking") Booking b) {

		// a booking can be passed as parameter
		// OR its id

		// if a not instanciated booking must be modified, create a new one
		if (b == null) {
			b = new Booking();
		}
		// if client is specified by id, set id
		if (id != null) {
			b.setId(id);
			b = bookingService.getBookingById(b);
		}
		// On passe une map des enums pour les afficher dans le select
		ModelAndView mav = new ModelAndView("admin/updateBooking", "booking", b);
		Map<Formula, String> formulas = new HashMap<Formula, String>();
		formulas.put(Formula.avion, Formula.avion.getDisplayName());
		formulas.put(Formula.avionHotel, Formula.avionHotel.getDisplayName());
		formulas.put(Formula.avionHotelVoiture, Formula.avionHotelVoiture.getDisplayName());
		formulas.put(Formula.avionVoiture, Formula.avionVoiture.getDisplayName());

		Map<Status, String> status = new HashMap<Status, String>();
		status.put(Status.accepte, Status.accepte.getDisplayName());
		status.put(Status.enAttente, Status.enAttente.getDisplayName());
		status.put(Status.enCours, Status.enCours.getDisplayName());
		status.put(Status.refuse, Status.refuse.getDisplayName());

		mav.addObject("enumFormula", formulas);
		mav.addObject("enumStatus", status);
		return mav;

	}

	@RequestMapping(value = { "updateBooking" }, method = RequestMethod.POST)
	public String submitUpdate(RedirectAttributes rda, Model model, @ModelAttribute("booking") Booking b) {

		// data validation
		if (b == null || b.getId() == 0) {
			rda.addFlashAttribute("errorMsg", "ID incorrect");
			rda.addFlashAttribute("booking", b);
			return "redirect:updateBooking";
		}

		// update
		boolean result = bookingService.updateBooking(b);
		System.out.println("POST updtae b");

		// si resa modifi� redirige sur l'acceuil
		if (result == true) {
			rda.addFlashAttribute("successMsg", "Booking modifi�");
			return "redirect:bookings";

			// si resa pas modifi� redirige sur le formulaire d'ajout
		} else {
			rda.addFlashAttribute("errorMsg", "La resa n'a pas �t� modifi�e");
			rda.addFlashAttribute("booking", b);
			return "redirect:updateBooking";
		}

	}

}

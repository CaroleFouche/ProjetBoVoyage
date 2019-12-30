package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Client;
import fr.adaming.entities.Formula;
import fr.adaming.entities.Status;
import fr.adaming.entities.Travel;
import fr.adaming.entities.Traveller;
import fr.adaming.services.IBookingService;
import fr.adaming.services.IClientService;

@Controller
@RequestMapping(value= {"/user"})
public class UserReserve {
	
	@Autowired
	public IClientService clientService;
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@Autowired
	public IBookingService bookingService;
	public void setBookingService(IBookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	
	/*
	 * Traiter le formulaire de réservation et renvoyer vers le paiement
	 */
	
	@RequestMapping(value = "reservation", method = RequestMethod.GET)
	public String getTravelReservation(RedirectAttributes rda, Model model, HttpServletRequest req) {
		
		
		HttpSession sess = req.getSession();
		Booking book = (Booking) sess.getAttribute("booking");
		Travel trvl = (Travel) sess.getAttribute("travelToReserve");
		System.out.println("book on travel : " + trvl);
		
		// si le booking n'existe pas, lui attribue le client et le voyage requis
		if(book == null || book.getId() == 0) {
			System.out.println("create new booking");
			book = new Booking();
			
			// TODO (defaut pour l'instant)
			book.setAssurance(true);
			book.setFormula(Formula.avionHotel);
			
			// Client
			//Recupere un object de type UserDetails qui stocke les infos du client connecté
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Client clIn = new Client();
			//On stock dans un nouveau client le login du client connecté
			clIn.setLogin(userDetails.getUsername());
			//On recupere le client stocké dans la BD (avec son ID)
			Client cl = clientService.getByLogin(clIn);
			
			book.setClient( cl );
		}
		
		// Travel
		if(trvl == null || trvl.getId() == 0) {
			rda.addFlashAttribute("errorMsg", "Veuillez choisir un voyage");
			return "redirect:/travels";
		}
		book.setTravel( trvl );
		
		
		System.out.println("current booking : " + book);
		//save in session
		sess.setAttribute("booking", book);
		
		// print in model
		model.addAttribute("booking", book);
		
		return "public/travelReservation";
	}
	
	
	@RequestMapping(value="setBookingClient", method = RequestMethod.POST)
	public String setBookingClient(RedirectAttributes rda, Model model, HttpServletRequest req,
			@ModelAttribute("booking") Booking book) {
		
		// save changes in session
		HttpSession sess = req.getSession();
		Booking sessBook = (Booking) sess.getAttribute("booking");
		sessBook.getClient().setName( book.getClient().getName() );
		sess.setAttribute("booking", sessBook);
		
		// print in model
		model.addAttribute("booking",sessBook);
		
		// debug
		System.out.println("*****************************");
		System.out.println(" setBookingClient ");
		System.out.println("booking: " + sessBook);
		System.out.println("*****************************");
		
		return "public/travelReservation";
	}
	
	
	
	@RequestMapping(value="setBookingNbTravellers", method = RequestMethod.POST)
	public String setBookingNbTravellers(RedirectAttributes rda, Model model, HttpServletRequest req,
			@ModelAttribute("booking") Booking book) {
		
		
		
		// ajout travellers
		int nb = book.getNbTravellers();
		// ajouter la liste des voyageurs a remplir
		List<Traveller> lTravellers = new ArrayList<Traveller>();
		for(int i = 0; i<nb; i++) {
			Traveller t = new Traveller();
			lTravellers.add( t );
		}
		
		
		// save changes in session
		HttpSession sess = req.getSession();
		Booking sessBook = (Booking) sess.getAttribute("booking");
		sessBook.setNbTravellers(book.getNbTravellers());
		sessBook.setTravellers(lTravellers);
		sess.setAttribute("booking", sessBook);
		
		// print in model
		model.addAttribute("booking", sessBook);
		
		System.out.println("*****************************");
		System.out.println(" setBookingNbTravellers ");
		System.out.println("booking: " + sessBook);
		System.out.println("*****************************");
		
		return "public/travelReservation";
	}
	
	
	@RequestMapping(value = "reservation", method = RequestMethod.POST)
	public String postTravelReservation(RedirectAttributes rda, Model model, HttpServletRequest req,
			@ModelAttribute("booking") Booking book) {
		
		
		// get booking from session
		HttpSession sess = req.getSession();
		Booking sessBook = (Booking) sess.getAttribute("booking");
		
		// set travellers edited from model
		List<Traveller> l = book.getTravellers();
		sessBook.setTravellers( l );
		for(int i = 0; i<l.size(); i++) {
			l.get(i).setBooking(sessBook);
		}
		
		//save in db
		sessBook.setStatus(Status.enCours);
		System.out.println(" ----> save booking : " + sessBook);
		
		if(sessBook.getId() == 0) {
			sessBook = bookingService.addBooking( sessBook );
		} else {
			bookingService.updateBooking( sessBook );
		}
		
		// verifie que le booking a un id attribué
		if(sessBook.getId() == 0) {
			rda.addFlashAttribute("errorMsg", "Erreur : La réservation n'a pas pu être sauvegardée");
			return "redirect:/user/dashboard";
		}
		
		return "public/travelPayment";
	}
	
	
	
	/*
	 * Traiter le formulaire de paiement et renvoyer vers le dashboard client
	 */
	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public String postTravelPayment(RedirectAttributes rda, Model model,  HttpServletRequest req,
			@ModelAttribute("booking") Booking book) {
		
		
		// get booking from session
		HttpSession sess = req.getSession();
		Booking sessBook = (Booking) sess.getAttribute("booking");
		
		// payment (TODO)
		sessBook.setStatus(Status.accepte);
		bookingService.updateBooking( sessBook );
		
		//delete booking from session when done
		sess.setAttribute("booking", null);
		
		System.out.println("**********   PAyment   *******");
		System.out.println("booking : " + sessBook);
		System.out.println("*****************************");

		return "redirect:/user/dashboard";
	}
	
}

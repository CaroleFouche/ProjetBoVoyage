package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Client;
import fr.adaming.entities.Image;
import fr.adaming.entities.Agencie;
import fr.adaming.entities.Travel;
import fr.adaming.services.ClientServiceImpl;
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

	//Méthode pour afficher tous les voyages disponibles
	@RequestMapping(method = RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		List<Travel> listTravel = travelService.areAvailable();
		modelDestinations.addAttribute("listTravels", listTravel);
		return "public/travels";
	}

	
	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String getTravelDetail(Model model, @RequestParam("pId") int id) {
			Travel travel = new Travel();
			travel.setId(id);		
			Travel tOut = travelService.getTravelById(travel);
			model.addAttribute("travel",tOut);	
		return "public/travelDetails";
	}
	
	
	// en cas de réservation, redirige sur un controleur client pour lui attibuer le voyage
	@RequestMapping(value = "reservation", method = RequestMethod.GET)
	public String getTravelReservation(Model model, @RequestParam("pId") int id, HttpServletRequest req) {
		Travel tIn = new Travel();
		tIn.setId(id);
		Travel trvl = travelService.getTravelById(tIn);
		
		HttpSession sess = req.getSession();
		sess.setAttribute("travelToReserve", trvl);
		
		return "redirect:/user/reservation";
	}
	
	
	// recup de l'image
	@RequestMapping(value = "img", method = RequestMethod.GET)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pId") int id) throws IOException {
		Travel tIn = new Travel();
		tIn.setId(id);
		Travel trvl = travelService.getTravelById(tIn);
		
		
		Image img=trvl.getDestination().getPics().get(0);
		img.setPhotoString("data:image/jpeg;base64," + Base64.encodeBase64String(img.getPhoto()));
		
		return IOUtils.toByteArray(new ByteArrayInputStream(img.getPhoto()));
	}

	
	
}

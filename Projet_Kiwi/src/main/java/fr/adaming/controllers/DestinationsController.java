package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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

import fr.adaming.entities.Destination;
import fr.adaming.entities.Image;
import fr.adaming.entities.Travel;
import fr.adaming.services.IDestinationService;

@Controller
@RequestMapping("/destinations")
public class DestinationsController {
	
	
	@Autowired
	private IDestinationService destinationService;
	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}


	@RequestMapping(method=RequestMethod.GET)
	public String getIndex(Model modelDestinations) {
		
		List<Destination> l = destinationService.getAllDestination();
		
		modelDestinations.addAttribute("list", l);
		
		return "public/destinations";
	}
	
	
	/*
	 *		Get ALL dest (TO BE FINISHED)
	 *
	 */
	@RequestMapping(value="all", method=RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		
		List<Destination> l = destinationService.getAllDestination();
		
		modelDestinations.addAttribute("list", l);
		
		return "public/destinations";
	}
	@RequestMapping(value="all", method=RequestMethod.POST)
	public String onPost(Model m, @ModelAttribute Destination dm) {
		
		return "public/destinations";
	}
	
	// recup de l'image
		@RequestMapping(value = "img", method = RequestMethod.GET)
		@ResponseBody
		public byte[] recupImage(@RequestParam("pId") int id) throws IOException {
			Destination dIn = new Destination();
			dIn.setId(id);
			Destination d = destinationService.getDestinationById(dIn);
			Random rand = new Random();
			int nombreAleatoire = rand.nextInt(d.getPics().size());


			Image img = d.getPics().get(nombreAleatoire);
			img.setPhotoString("data:image/jpeg;base64," + Base64.encodeBase64String(img.getPhoto()));
			
			return IOUtils.toByteArray(new ByteArrayInputStream(img.getPhoto()));
		}
	
	
	
	
	
	
}
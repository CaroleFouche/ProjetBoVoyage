package fr.adaming.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Destination;
import fr.adaming.entities.Image;
import fr.adaming.services.IDestinationService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminDestinationsController {

	@Autowired
	public IDestinationService destinationService;

	public void setDestinationService(IDestinationService destinationService) {
		this.destinationService = destinationService;
	}

	@RequestMapping(value = { "destinations" }, method = RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		List<Destination> d = destinationService.getAllDestination();
		modelDestinations.addAttribute("listDestinations", d);
		return "admin/adminDestinations";
	}

	/*
	 * Ajouter une destination
	 */

	@RequestMapping(value = { "addDestination" }, method = RequestMethod.GET)
	public ModelAndView afficherAdd(@ModelAttribute("destinations") Destination d) {
		// d can be passed by POST if addDestination has failed. avoid to rewrite d
		// params.
		if (d == null) {
			d = new Destination();
		}
		return new ModelAndView("admin/addDestination", "destination", d);
	}

	@RequestMapping(value = { "submitAddDestination" }, method = RequestMethod.POST)
	public String submitAdd(Model model, @ModelAttribute("destination") Destination d,
			@RequestParam("files") MultipartFile[] files, RedirectAttributes rda) {

		if (files.length != 0) {
			List<Image> listeImages = new ArrayList<Image>();

			for (MultipartFile file : files) {
				Image image = new Image();
				try {
					System.out.println("============ " + file.getBytes());
					image.setPhoto(file.getBytes());
					image.setDestination(d);
				} catch (IOException e) {
					e.printStackTrace();
				}

				listeImages.add(image);
			}

			d.setPics(listeImages);

		}
		// else {
//			if (d.getId() != 0) {
//				Destination des = (Destination) model.asMap().get("editedDest");
//				d.setPic(des.getPic());
//			}
//		}
		Destination dOut = destinationService.addDestination(d);
		// si la destination est ajouté redirige sur l'acceuil
		if (dOut != null) {
			rda.addFlashAttribute("successMsg", "Destination ajoutée");
			return "redirect:destinations";
		} else { // si la destination n'est pas ajoutée redirige sur le formulaire d'ajout
			rda.addFlashAttribute("errorMsg", "La destination n'a pas été ajoutée");
			rda.addFlashAttribute("destination", d);
			return "redirect:addDestination";
		}
	}

	/*
	 * Modifier Destination
	 */

	@RequestMapping(value = { "updateDestination" }, method = RequestMethod.GET)
	public ModelAndView afficherUpdate(@RequestParam(value = "pId", required = false) Integer id,
			@ModelAttribute("destination") Destination d) {

		// a destination can be passed as parameter
		// OR its id

		// if a not instanciated destination must be modified, create a new one
		if (d == null) {
			d = new Destination();
		}
		// if destination is specified by id, set id
		if (id != null) {
			d.setId(id);
			d = destinationService.getDestinationById(d);
		}
		return new ModelAndView("admin/updateDestination", "destination", d);
	}

	@RequestMapping(value = { "updateDestination" }, method = RequestMethod.POST)
	public String submitUpdate(Model model, @ModelAttribute("destination") Destination d,
			@RequestParam("files") MultipartFile[] files, RedirectAttributes rda) {

		// data validation
		if (d == null || d.getId() == 0) {
			rda.addFlashAttribute("errorMsg", "ID incorrect");
			rda.addFlashAttribute("destination", d);
			return "redirect:updateDestination";
		}

		System.out.println("====================     "+files.length);
		if (files.length != 0) {
			List<Image> listeImages =destinationService.getDestinationById(d).getPics();
		
			for (int i=0;i<files.length;i++) {
		
				try {
					System.out.println("====================     "+listeImages.get(i).getId());
					listeImages.get(i).setPhoto(files[i].getBytes());
					listeImages.get(i).setDestination(d);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			d.setPics(listeImages);

		} else {
			d.setPics(destinationService.getDestinationById(d).getPics());
		}
		// update
		boolean result = destinationService.updateDestination(d);
		System.out.println("POST updtae d");

		// si destination modifié redirige sur l'acceuil
		if (result == true) {
			rda.addFlashAttribute("successMsg", "Destination modifiée");
			return "redirect:destinations";

			// si destination pas modifié redirige sur le formulaire d'ajout
		} else {
			rda.addFlashAttribute("errorMsg", "La destination n'a pas été modifiée");
			rda.addFlashAttribute("destination", d);
			return "redirect:updateDestination";
		}

	}

	/*
	 * Supprimer Destination
	 */
	@RequestMapping(value = { "deleteDestination" }, method = RequestMethod.GET)
	public String onDeletePost(RedirectAttributes rda, Model model, @RequestParam("pId") int id) {

		// si id inconnu
		if (id == 0) {
			rda.addFlashAttribute("errorMsg", "Id destination inconnu");
			return "redirect:destinations";
		}

		// recupere le client correspondant a l'id et le supprime
		Destination d = new Destination();
		d.setId(id);
		boolean result = destinationService.deleteDestination(d);

		if (result == true) {
			rda.addFlashAttribute("successMsg", "Destination supprimée");
		} else {
			rda.addFlashAttribute("errorMsg", "La destination n'a pas été supprimé");
		}
		return "redirect:destinations";
	}

}

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

import fr.adaming.entities.Client;
import fr.adaming.services.IClientService;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminClientsController {
	
	
	@Autowired
	public IClientService clientService;
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	
	/*
	 *  page principale : afficher tous les clients
	 */
	
	@RequestMapping(value= {"clients"}, method=RequestMethod.GET)
	public String getAll(Model model) {
		List<Client> l = clientService.getAllClient();
		model.addAttribute("listClients", l);
		return "admin/adminClients";
	}
	
	
	
	
	/*
	 *  Ajouter Client
	 */
	
	@RequestMapping(value= {"addClient"},  method = RequestMethod.GET)
	public ModelAndView afficherAdd(@ModelAttribute("client") Client cl) {
		// cl can be passed by POST if addCLient has failed. avoid to rewrite cl params.
		if(cl == null) {
			cl = new Client();
		}
		return new ModelAndView("admin/addClient", "client", cl);
	}
	@RequestMapping(value= {"submitAddClient"},  method = RequestMethod.POST)
	public String submitAdd(RedirectAttributes rda, Model model, @ModelAttribute("client") Client cl) {
		Client clOut = clientService.addClient(cl);
		// si client ajouté rtedirige sur l'acceuil
		if (clOut != null) {
			rda.addFlashAttribute("successMsg", "Client ajouté");
			return "redirect:clients";
		} else {  // si client pas ajouté redirige sur le formulaire d'ajout
			rda.addFlashAttribute("errorMsg", "Le client n'a pas été ajouté");
			rda.addFlashAttribute("client", cl);
			return "redirect:addClient";
		}
	}
	
	
	
	
	
	/*
	 *  Modifier Client
	 */
	
	@RequestMapping(value= {"updateClient"},  method = RequestMethod.GET)
	public ModelAndView afficherUpdate(@RequestParam(value="pId", required=false) Integer id,
			@ModelAttribute("client") Client cl) {
		
		// a client can be passed as parameter
		// OR its id
		
		// if a not instanciated client must be modified, create a new one
		if(cl == null) {
			cl = new Client();
		}
		// if client is specified by id, set id
		if(id != null) {
			cl.setId(id);
			cl = clientService.getClientById( cl );
		}
		return new ModelAndView("admin/updateClient", "client", cl);
	}
	@RequestMapping(value= {"updateClient"},  method = RequestMethod.POST)
	public String submitUpdate(RedirectAttributes rda, Model model, @ModelAttribute("client") Client cl) {
		
		// data validation
		if(cl == null || cl.getId() == 0) {
			rda.addFlashAttribute("errorMsg", "ID incorrect");
			rda.addFlashAttribute("client", cl);
			return "redirect:updateClient";
		}
		
		// update
		boolean result = clientService.updateClient(cl);
		System.out.println("POST updtae cl");
		
		// si client modifié redirige sur l'acceuil
		if (result == true) {
			rda.addFlashAttribute("successMsg", "Client modifié");
			return "redirect:clients";
		
		// si client pas modifié redirige sur le formulaire d'ajout
		} else {  
			rda.addFlashAttribute("errorMsg", "Le client n'a pas été modifié");
			rda.addFlashAttribute("client", cl);
			return "redirect:updateClient";
		}
		
	}
	
	
	
	
	/*
	 *  Supprimer Client
	 */
	@RequestMapping(value= {"deleteClient"},  method = RequestMethod.GET)
	public String onDeletePost(RedirectAttributes rda, Model model, @RequestParam("pId") int id) {
		
		// si id inconnu
		if (id == 0) {
			rda.addFlashAttribute("errorMsg", "Id client inconnu");
			return "redirect:clients";
		} 
		
		// recupere le client correspondant a l'id et le supprime
		Client cl = new Client();
		cl.setId(id);
		boolean result = clientService.deleteClient(cl);
		
		if (result == true) {
			rda.addFlashAttribute("successMsg", "Client supprimé");
		} else {
			rda.addFlashAttribute("errorMsg", "Le client n'a pas été supprimé");
		}
		return "redirect:clients";
	}
}

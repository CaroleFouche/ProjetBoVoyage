package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Client;
import fr.adaming.entities.Role;
import fr.adaming.services.IClientService;
import fr.adaming.services.IRoleService;

@Controller

public class LoginController {
	
	
	@Autowired
	IRoleService roleService;
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	
	@Autowired
	IClientService clientService;
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	//Affiche le formulaire de login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficheFormLogin() {
		return "public/login";	
	}
	
	@RequestMapping(value="/echec", method=RequestMethod.GET)
	public String erreurLogin(Model modele) {
		modele.addAttribute("msg", "Identifiants incorrects, veuillez reessayer");
		return "public/login";
	}
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String afficheDenied() {
		return "public/deniedPage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String afficheLogOut(Model modele) {
		modele.addAttribute("msg", "Vous etes deconnecté");
		return "home";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		return "public/signup";
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signuppost(Model model, @ModelAttribute("client") Client cl) {
		
		System.out.println("add client : " + cl);
		
		
		cl = clientService.addClient(cl);
		if(cl.getId() == 0) {
			model.addAttribute("errorMsg", "Impossible d'enregistrer le nouveau compte");
			return "public/signup";
		}
		
		Role role = new Role();
		role.setName(cl.getName());
		role.setClient(cl);
		
		System.out.println(" with role : " + role);
		
		role = roleService.addRole(role);
		
		if(role.getId() == 0) {
			model.addAttribute("errorMsg", "Impossible d'enregistrer le nouveau compte");
			return "public/signup";
		}
		
		model.addAttribute("successMsg", "Votre compte a été créé avec success !");
		return "home";
	}
	
	
	
}

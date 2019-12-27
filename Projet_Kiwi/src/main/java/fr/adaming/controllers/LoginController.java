package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class LoginController {
	
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
	
	
	
}

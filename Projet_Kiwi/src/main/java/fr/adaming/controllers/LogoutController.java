package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String getAllDestinations(Model modelDestinations) {
		return "public/login";
	}
	
}

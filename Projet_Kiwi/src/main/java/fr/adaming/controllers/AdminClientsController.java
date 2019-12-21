package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminClientsController {
	
	
	@RequestMapping(value= {"clients"}, method=RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		return "admin/adminClients";
	}
	
}

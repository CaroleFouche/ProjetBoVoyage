package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= {"/user"})
public class UserAccountController {
	
	
	@RequestMapping(value= {"myAccount"}, method=RequestMethod.GET)
	public String getAllDestinations(Model modelDestinations) {
		return "user/myAccount";
	}
	
}

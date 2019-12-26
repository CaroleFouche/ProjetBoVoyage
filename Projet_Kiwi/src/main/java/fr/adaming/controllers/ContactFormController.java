package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Client;
import fr.adaming.entities.Contact;
import fr.adaming.utilities.MailConfig;

@Controller
@RequestMapping(value = { "/contact" })
public class ContactFormController {

	@Autowired
	public MailConfig mailService;

	// Affichage du formulaire de contact
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView afficherForm(@ModelAttribute("contact") Contact c) {
		if (c == null) {
			c = new Contact();
		}
		return new ModelAndView("public/contact", "contact", c);
	}

	@RequestMapping(value = "sendSimpleEmail", method = RequestMethod.POST)
	public String sendSimpleEmail(Model model, @ModelAttribute("contact") Contact c) {

		mailService.sendMail("carole.fouche33@gmail.com",
				"Vous avez recu un mail de " + c.getName() + " ( " + c.getEmail() + " ) " + " : " + c.getText());
		return "public/contact";

	}

}

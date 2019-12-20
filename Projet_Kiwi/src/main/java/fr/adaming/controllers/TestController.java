package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/test")
public class TestController {
	
	
//	@Autowired
//	private IEtudiantService etudiantService;
//	public void setFormService(IEtudiantService etudiantService) {
//		this.etudiantService = etudiantService;
//	}
	
//	private Formateur f;
//	
//	
//	@PostConstruct
//	public void init() {
//		this.f = new Formateur(1, "a", "a");
//	}
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		
//		df.setLenient(false);
//		
//		// la methode registerCustomEditor configure la conversion du param recu au type de l'attribu
//		// l'objet CustomDateEditor sert a lier la date recue comme param de la requete a l'attr de l'objet Etudiant
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
//	}
//	
//	
//	@RequestMapping(value="add", method=RequestMethod.GET)
//	public ModelAndView getAdd() {
//		Etudiant e = new Etudiant();
//		return new ModelAndView("add", "etudiant", e);
//	}
//	@RequestMapping(value="add", method=RequestMethod.POST)
//	public ModelAndView postAdd(ModelMap model, @ModelAttribute Etudiant etudiant) {
//		
//		System.out.println("add etudiant e : " + etudiant);
//		
//		int res = etudiantService.add(etudiant, this.f);
//		
//		if(res == 0) {
//			System.out.println("cannot add etudiant...");
//			return new ModelAndView("redirect:add");
//		}
//		
//		Etudiant e = new Etudiant();
//		return new ModelAndView("add", "etudiant", e);
//	}
}

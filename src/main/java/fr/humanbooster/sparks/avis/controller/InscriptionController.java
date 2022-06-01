package fr.humanbooster.sparks.avis.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InscriptionController {
	
	@GetMapping("/inscription")
	public ModelAndView inscriptionGet() {
		ModelAndView mav = new ModelAndView("inscription");
		return mav;
	}
	
	@PostMapping("/inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result) {
		ModelAndView mav = new ModelAndView("inscrirption");
		
		if (result.hasErrors()) {
			// Faire quelque chose.
		}
		
		return mav;
	}
}

package fr.humanbooster.sparks.avis.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InscriptionController {
	
	private final JoueurService joueurService;
	
	@GetMapping("/inscription")
	public ModelAndView inscriptionGet(Joueur joueur) {
		ModelAndView mav = new ModelAndView("inscription");
		return mav;
	}
	
	@PostMapping("/inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute("joueur") Joueur joueur, BindingResult result) {
		
		if (result.hasErrors()) {
			ModelAndView mav = inscriptionGet(joueur);
			mav.addObject("joueur", joueur);
			
			return mav;
		}
		
		joueurService.ajouterJoueur(joueur);
		
		return new ModelAndView("redirect:/");
	}
}

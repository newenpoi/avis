package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	private final HttpSession httpSession;
	
	@GetMapping({"/", "/index"})
	public ModelAndView indexGet() {
		// Récupère la session éventuelle du joueur.
		Joueur joueur = (Joueur) httpSession.getAttribute("joueur");
		
		// Si le joueur est authentifié le rediriger vers /avis.
		if (joueur != null) return new ModelAndView("redirect:/avis");
		
		return new ModelAndView("index");
	}
}
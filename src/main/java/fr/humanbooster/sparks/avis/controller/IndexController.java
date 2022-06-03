package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	private final HttpSession httpSession;
	
	@GetMapping({"/", "/index"})
	public ModelAndView indexGet() {
		// Récupère la session éventuelle du joueur.
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		// Si le joueur est authentifié le rediriger vers /avis.
		// On pourrait peut être afficher une jsp en fonction de si c'est un utilisateur ou un modérateur.
		if (utilisateur != null) return new ModelAndView("redirect:/avis");
		
		return new ModelAndView("index");
	}
}
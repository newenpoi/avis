package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	private final JoueurService joueurService;
	private final HttpSession httpSession;
	
	@GetMapping({"/", "index"})
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@PostMapping("/connexion")
	public ModelAndView connexionPost(@RequestParam("email") String email, @RequestParam("motDePasse") String motDePasse) {
		
		ModelAndView mav = new ModelAndView();

		// Tentative de connexion de l'utilisateur.
		Joueur joueur = joueurService.recupererJoueur(email, motDePasse);
		
		// Si aucun utilisateur n'est récupéré ou que le mot de passe ne correspond pas.
		if (joueur == null || joueur.getMotDePasse() != motDePasse) {
			mav.setViewName("connexion");
			mav.addObject("erreur", "Identifiants Incorrects");
		}
		else {
			// Les identifiants sont corrects, ajout d'une session et de son attribut.
			httpSession.setAttribute("joueur", joueur);
			return new ModelAndView("redirect:avis");
		}

		return mav;
	}
}
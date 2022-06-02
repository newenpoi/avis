package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ConnexionController {
	
	private final JoueurService joueurService;
	private final HttpSession httpSession;
	
	@PostMapping("/connexion")
	public ModelAndView connexionPost(@RequestParam("pseudo") String pseudo, @RequestParam("motDePasse") String motDePasse) {
		
		ModelAndView mav = new ModelAndView("redirect:/index");

		// Tentative de connexion de l'utilisateur.
		Joueur joueur = joueurService.recupererJoueur(pseudo, motDePasse);
		
		// Si aucun utilisateur n'est récupéré ou que le mot de passe ne correspond pas.
		if (joueur == null || !joueur.getMotDePasse().equals(motDePasse)) {
			mav.addObject("erreur", "Identifiants Incorrects");
		}
		else {
			// Les identifiants sont corrects, ajout d'une session et de son attribut, redirection.
			httpSession.setAttribute("joueur", joueur);
			return new ModelAndView("redirect:/avis");
		}

		return mav;
	}
}

package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import fr.humanbooster.sparks.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ConnexionController {
	
	private final UtilisateurService utilisateurService;
	private final HttpSession httpSession;
	
	@PostMapping("/connexion")
	public ModelAndView connexionPost(@RequestParam("pseudo") String pseudo, @RequestParam("motDePasse") String motDePasse) {
		
		ModelAndView mav = new ModelAndView("redirect:/index");

		// Tentative de connexion de l'utilisateur.
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(pseudo, motDePasse);
		
		// Si aucun utilisateur n'est récupéré ou que le mot de passe ne correspond pas.
		if (utilisateur == null || !utilisateur.getMotDePasse().equals(motDePasse)) {
			mav.addObject("erreur", "Identifiants Incorrects");
		}
		else {
			// Les identifiants sont corrects, ajout d'une session et de son attribut, redirection.
			httpSession.setAttribute("utilisateur", utilisateur);
			return new ModelAndView("redirect:/avis");
		}

		return mav;
	}
}

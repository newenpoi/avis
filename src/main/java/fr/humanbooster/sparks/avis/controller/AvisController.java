package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvisController {
	
	private final AvisService avisService;
	private final JeuService jeuService;
	private final HttpSession httpSession;
	
	@GetMapping("/avis")
	public ModelAndView avisGet() {
		// Déclaration.
		ModelAndView mav = new ModelAndView("avis");
		
		// Récupérer les avis dans la base de données.
		mav.addObject("avis", avisService.recupererAvis());
		
		// Renvoyer la vue.
		return mav;
	}
	
	@GetMapping("/avis/ajouter")
	public ModelAndView avisAjouterGet() {
		ModelAndView mav = new ModelAndView("avis-ajouter");
		mav.addObject("jeux", jeuService.recupererJeux());
		
		return mav;
	}
	
	@PostMapping("/avis/ajouter")
	public ModelAndView avisPost(@RequestParam("jeu") Long idJeu, @RequestParam("description") String description, @RequestParam("note") float note) {
		
		Joueur joueur = (Joueur) httpSession.getAttribute("joueur");
		Avis avis = avisService.ajouterAvis(idJeu, description, note, joueur);
		
		// Alerte, crash (stack overflow) si les annotations ToString.Exclude ne sont pas définies sur joueur et jeu de la classé métier Avis.
		System.out.println(avis);
		
		return new ModelAndView("redirect:/avis");
	}
}

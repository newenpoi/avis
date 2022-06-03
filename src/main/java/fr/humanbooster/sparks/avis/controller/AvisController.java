package fr.humanbooster.sparks.avis.controller;


import javax.servlet.http.HttpSession;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
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
	
	private final static int NB_JOUR_PAR_PAGE = 5;
	
	private final AvisService avisService;
	private final JeuService jeuService;
	private final HttpSession httpSession;
	
	/**
	 * Cette vue renvoie la liste des avis en attente de modération du joueur connecté.
	 * Ansi que ses avis ayant été modérés.
	 * TODO : Tri.
	 * @return
	 */
	@GetMapping("/avis")
	public ModelAndView avisGet(@PageableDefault(size = NB_JOUR_PAR_PAGE, sort = "dateEnvoi") Pageable page, 
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "sort", defaultValue = "dateEnvoi") String sort) {
		
		// Déclaration.
		ModelAndView mav = new ModelAndView("avis");
		
		mav.addObject("avis", avisService.recupererAvis(page.withPage(numPage)));
		mav.addObject("sort", sort);
		
		if (page != null) httpSession.setAttribute("numeroDePage", numPage);;
		
		// Renvoyer la vue.
		return mav;
	}
	
	/**
	 * Cette vue affiche le formulaire d'ajout d'un avis.
	 * @return
	 */
	@GetMapping("/avis/ajouter")
	public ModelAndView avisAjouterGet() {
		ModelAndView mav = new ModelAndView("avis-ajouter");
		mav.addObject("jeux", jeuService.recupererJeux());
		
		return mav;
	}
	
	/**
	 * Cette route récupère des données POST dans le but d'ajouter un nouvel avis en base de données.
	 * Elle fait appel à la couche service et à la dao.
	 * TODO : Fournir une vérfication des données.
	 * @param idJeu
	 * @param description
	 * @param note
	 * @return
	 */
	@PostMapping("/avis/ajouter")
	public ModelAndView avisPost(@RequestParam("jeu") Long idJeu, @RequestParam("description") String description, @RequestParam("note") float note) {
		
		// Cast Utilisateur vers Joueur.
		Joueur joueur = (Joueur) httpSession.getAttribute("utilisateur");
		Avis avis = avisService.ajouterAvis(idJeu, description, note, joueur);
		
		// Alerte, crash (stack overflow) si les annotations ToString.Exclude ne sont pas définies sur joueur et jeu de la classé métier Avis.
		System.out.println(avis);
		
		return new ModelAndView("redirect:/avis");
	}
}

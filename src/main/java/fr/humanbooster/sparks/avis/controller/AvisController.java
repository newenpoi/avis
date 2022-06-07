package fr.humanbooster.sparks.avis.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.business.Moderateur;
import fr.humanbooster.sparks.avis.business.Utilisateur;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.CSVExportService;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvisController {
	
	private final static int NB_AVIS_PAR_PAGE = 5;
	
	private final AvisService avisService;
	private final JeuService jeuService;
	private final HttpSession httpSession;
	private final CSVExportService csvExportService;
	
	/**
	 * Cette vue renvoie la liste des avis en attente de modération du joueur connecté.
	 * Ansi que ses avis ayant été modérés.
	 * TODO : Tri.
	 * @return
	 */
	@GetMapping("/avis")
	public ModelAndView avisGet(@PageableDefault(size = NB_AVIS_PAR_PAGE, sort = {"dateModeration", "dateEnvoi"}) Pageable page, 
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "sort", defaultValue = "dateEnvoi") String sort) {
		
		// Déclaration.
		ModelAndView mav = new ModelAndView("avis");
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		// Renvoie les données en fonction du type de l'utilisateur.
		if (utilisateur.getClass().getSimpleName().equals("Joueur")) {
			mav.addObject("avis", avisService.recupererAvisJoueurConnecte(page.withPage(numPage), utilisateur.getId()));
		}
		else {
			mav.addObject("avis", avisService.recupererAvis(page.withPage(numPage)));
		}
		
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
	public ModelAndView avisPost(@RequestParam("jeu") Long idJeu, @RequestParam("description") String description, @RequestParam("note") Float note) {
		
		// Si la note n'est pas valide (ex : 16.3 / 20).
		if ((note * 10) % 5 != 0) return new ModelAndView("redirect:/avis");
		
		// Cast Utilisateur vers Joueur.
		Joueur joueur = (Joueur) httpSession.getAttribute("utilisateur");
		avisService.ajouterAvis(idJeu, description, note, joueur);
		
		return new ModelAndView("redirect:/avis");
	}
	
	@GetMapping("/avis/voir")
	public ModelAndView avisVoirGet(@RequestParam("idAvis") Long idAvis) {
		ModelAndView mav = new ModelAndView("avis-voir");
		mav.addObject(avisService.recupererAvisUnique(idAvis));
		
		return mav;
	}
	
	@GetMapping("/avis/valider")
	public ModelAndView avisValiderGet(@RequestParam("idAvis") Long idAvis) {
		
		// TODO : Filtrer cette méthode accessible uniquement aux modérateurs.
		// On récupère le modérateur de cette session.
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		if (utilisateur.getClass().getSimpleName().equals("Moderateur")) avisService.validerAvis(idAvis, (Moderateur) utilisateur);
		
		return new ModelAndView("redirect:/avis");
	}
	
	@GetMapping("/avis/refuser")
	public ModelAndView avisRefuserGet(@RequestParam("idAvis") Long idAvis) {
		
		// On récupère le modérateur de cette session.
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		if (utilisateur.getClass().getSimpleName().equals("Moderateur")) avisService.supprimerAvis(idAvis);
		
		return new ModelAndView("redirect:/avis");
	}
	
	@GetMapping(path = "/avis/exporter", produces = "text/csv")
	public void avisExporterGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.addHeader("Content-Disposition", "attachment; filename = \"avis.csv\"");
		csvExportService.ExportCSV(res.getWriter());
	}
}

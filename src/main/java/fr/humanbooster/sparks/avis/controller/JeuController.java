package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.service.ClassificationService;
import fr.humanbooster.sparks.avis.service.EditeurService;
import fr.humanbooster.sparks.avis.service.GenreService;
import fr.humanbooster.sparks.avis.service.JeuService;
import fr.humanbooster.sparks.avis.service.ModeleEconomiqueService;
import fr.humanbooster.sparks.avis.service.PlateFormeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class JeuController {
	
	private final static int NB_JEUX_PAR_PAGE = 5;
	
	private final JeuService jeuService;
	private final EditeurService editeurService;
	private final GenreService genreService;
	private final ClassificationService classificationService;
	private final PlateFormeService plateformeService;
	private final ModeleEconomiqueService modeleEconomiqueService;
	private final HttpSession httpSession;
	
	@GetMapping("/jeux")
	public ModelAndView jeuxGet(@PageableDefault(size = NB_JEUX_PAR_PAGE, sort = "nom") Pageable page, 
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "sort", defaultValue = "nom") String sort) {
		
		// Déclaration.
		ModelAndView mav = new ModelAndView("jeux");
		
		// Récupère la liste de jeux depuis le service.
		mav.addObject("jeux", jeuService.recupererJeux(page.withPage(numPage)));
		mav.addObject("sort", sort);
		
		if (page != null) httpSession.setAttribute("numeroDePage", numPage);;
		
		return mav;
	}
	
	@GetMapping("/jeux/ajouter")
	public ModelAndView jeuxAjouterGet(Jeu jeu) {
		
		ModelAndView mav = new ModelAndView("jeux-ajouter");
		
		mav.addObject("editeurs", editeurService.recupererEditeurs());
		mav.addObject("genres", genreService.recupererGenres());
		mav.addObject("classifications", classificationService.recupererClassifications());
		mav.addObject("plateformes", plateformeService.recupererPlateformes());
		mav.addObject("modelesEconomiques", modeleEconomiqueService.recupererModelesEconomiques());
		
		return mav;
	}
	
	@PostMapping("/jeux/ajouter")
	public ModelAndView jeuxAjouterPost(@Valid @ModelAttribute("jeu") Jeu jeu, BindingResult result) {
		
		if (result.hasErrors()) {
			
			ModelAndView mav = jeuxAjouterGet(jeu);
			mav.addObject("jeu", jeu);
			mav.addObject("errors", result.getAllErrors());
			
			return mav;
		}
		
		jeuService.ajouterJeu(jeu);
		
		return new ModelAndView("redirect:/jeux");
	}
	
	@GetMapping("/jeux/modifier")
	public ModelAndView jeuxModifierGet(@RequestParam("idJeu") Long idJeu) {
		
		// Déclaration.
		ModelAndView mav = new ModelAndView("jeux-modifier");
		
		// Récupère les informations du jeu par son identifiant.
		Jeu jeu = jeuService.recupererJeu(idJeu);
		mav.addObject(jeu);
		
		mav.addObject("editeurs", editeurService.recupererEditeurs());
		mav.addObject("genres", genreService.recupererGenres());
		mav.addObject("classifications", classificationService.recupererClassifications());
		mav.addObject("plateformes", plateformeService.recupererPlateformes());
		mav.addObject("modelesEconomiques", modeleEconomiqueService.recupererModelesEconomiques());
		
		return mav;
	}
	
	@PostMapping("jeux/modifier")
	public ModelAndView jeuxModifierPost(@Valid @ModelAttribute("jeu") Jeu jeu, BindingResult result) {
		
		if (result.hasErrors()) {
			
			ModelAndView mav = jeuxAjouterGet(jeu);
			mav.setViewName("jeux-modifier");
			
			mav.addObject("jeu", jeu);
			mav.addObject("errors", result.getAllErrors());
			
			return mav;
		}
		
		jeuService.updateJeu(jeu);
		
		return new ModelAndView("redirect:/jeux");
	}
	
	@GetMapping("/jeux/supprimer")
	public ModelAndView jeuxDelete(@RequestParam("idJeu") Long idJeu) {
		
		jeuService.supprimerJeu(idJeu);
		
		return new ModelAndView("redirect:/jeux");
	}
	
	@GetMapping("jeux/voir")
	public ModelAndView jeuxVoirGet(@RequestParam("idJeu") Long idJeu) {
		ModelAndView mav = new ModelAndView("jeux-voir");
		mav.addObject("jeu", jeuService.recupererJeu(idJeu));
		
		return mav;
	}
}

package fr.humanbooster.sparks.avis.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	private final JeuService jeuService;
	private final EditeurService editeurService;
	private final GenreService genreService;
	private final ClassificationService classificationService;
	private final PlateFormeService plateformeService;
	private final ModeleEconomiqueService modeleEconomiqueService;
	
	@GetMapping("/jeux")
	public ModelAndView jeuxGet() {
		
		// Déclaration.
		ModelAndView mav = new ModelAndView("/jeux");
		
		// Récupère la liste de jeux depuis le service.
		mav.addObject("jeux", jeuService.recupererJeux());
		
		
		return mav;
	}
	
	@GetMapping("/jeux/ajouter")
	public ModelAndView jeuxAjouterGet(Jeu jeu) {
		
		ModelAndView mav = new ModelAndView("/jeux-ajouter");
		
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
		
		return new ModelAndView("redirect:/");
	}
}
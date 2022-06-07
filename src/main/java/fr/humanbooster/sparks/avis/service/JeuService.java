package fr.humanbooster.sparks.avis.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.sparks.avis.business.Jeu;

public interface JeuService {

	Jeu recupererJeu(Long idJeu);
	List<Jeu> recupererJeux();
	Jeu ajouterJeu(@Valid Jeu jeu);
	Jeu updateJeu(@Valid Jeu jeu);
	void supprimerJeu(Long idJeu);
	Page<Jeu> recupererJeux(Pageable withPage);

}

package fr.humanbooster.sparks.avis.service;

import java.util.List;

import fr.humanbooster.sparks.avis.business.Jeu;

public interface JeuService {

	Jeu recupererJeu(Long idJeu);
	List<Jeu> recupererJeux();

}

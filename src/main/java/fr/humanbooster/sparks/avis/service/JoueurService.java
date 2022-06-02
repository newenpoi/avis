package fr.humanbooster.sparks.avis.service;

import javax.validation.Valid;

import fr.humanbooster.sparks.avis.business.Joueur;

public interface JoueurService {

	Joueur recupererJoueur(String pseudo, String motDePasse);
	Joueur ajouterJoueur(@Valid Joueur joueur);

}

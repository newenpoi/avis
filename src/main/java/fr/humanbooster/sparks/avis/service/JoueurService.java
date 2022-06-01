package fr.humanbooster.sparks.avis.service;

import fr.humanbooster.sparks.avis.business.Joueur;

public interface JoueurService {

	Joueur recupererJoueur(String email, String motDePasse);

}

package fr.humanbooster.sparks.avis.service;

import fr.humanbooster.sparks.avis.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur recupererUtilisateur(String pseudo, String motDePasse);

}

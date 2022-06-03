package fr.humanbooster.sparks.avis.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.business.Joueur;

public interface AvisService {

	List<Avis> recupererAvis();
	Avis ajouterAvis(Avis avis);
	Avis ajouterAvis(Long idJeu, String description, Float note, Joueur joueur);
	Page<Avis> recupererAvis(Pageable withPage);

}

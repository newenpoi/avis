package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Avis;

public interface AvisDao extends JpaRepository<Avis, Long> {
	
	// Cette requête est utilisée pour récupérer les avis des joueurs modérés ainsi que les
	// avis en attente de l'utilisateur connecté.
	Page<Avis> findByDateModerationIsNotNullOrJoueurIdEquals(Pageable page, Long id);
	
	Page<Avis> findByDateModerationIsNotNullOrDateModerationIsNullAndJoueurIdEquals(Pageable page, Long id);
}

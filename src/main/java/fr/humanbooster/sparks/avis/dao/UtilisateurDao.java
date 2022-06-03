package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>  {

	Utilisateur findByPseudo(String pseudo);
	
}

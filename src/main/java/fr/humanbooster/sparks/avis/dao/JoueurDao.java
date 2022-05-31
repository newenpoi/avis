package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Joueur;

public interface JoueurDao extends JpaRepository<Joueur, Long>  {

}

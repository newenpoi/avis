package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Jeu;

public interface JeuDao extends JpaRepository<Jeu, Long> {

}

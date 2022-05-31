package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Avis;

public interface AvisDao extends JpaRepository<Avis, Long> {

}

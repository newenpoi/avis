package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Moderateur;

public interface ModerateurDao extends JpaRepository<Moderateur, Long> {
}

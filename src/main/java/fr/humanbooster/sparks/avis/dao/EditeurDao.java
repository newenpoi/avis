package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Editeur;

public interface EditeurDao extends JpaRepository<Editeur, Long> {

}

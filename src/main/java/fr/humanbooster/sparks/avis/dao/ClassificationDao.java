package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Classification;

public interface ClassificationDao extends JpaRepository<Classification, Long> {

}

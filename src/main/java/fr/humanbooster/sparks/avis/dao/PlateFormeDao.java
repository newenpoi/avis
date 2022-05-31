package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.PlateForme;

public interface PlateFormeDao extends JpaRepository<PlateForme, Long> {

}

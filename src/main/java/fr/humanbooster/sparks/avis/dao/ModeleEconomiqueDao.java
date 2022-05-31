package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.ModeleEconomique;

public interface ModeleEconomiqueDao extends JpaRepository<ModeleEconomique, Long> {

}

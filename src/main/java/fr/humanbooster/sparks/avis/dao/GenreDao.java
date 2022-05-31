package fr.humanbooster.sparks.avis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sparks.avis.business.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {

}

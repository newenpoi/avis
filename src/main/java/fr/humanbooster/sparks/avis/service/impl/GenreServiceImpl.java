package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Genre;
import fr.humanbooster.sparks.avis.dao.GenreDao;
import fr.humanbooster.sparks.avis.service.GenreService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

	private final GenreDao genreDao;

	@Override
	public List<Genre> recupererGenres() {
		return genreDao.findAll();
	}
	
}

package fr.humanbooster.sparks.avis.service.impl;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.dao.JoueurDao;
import fr.humanbooster.sparks.avis.service.JoueurService;

@Service
public class JoueurServiceImpl implements JoueurService {
	
	private JoueurDao joueurDao;

	@Override
	public Joueur recupererJoueur(String email, String motDePasse) {
		return joueurDao.findByEmail(email);
	}

}

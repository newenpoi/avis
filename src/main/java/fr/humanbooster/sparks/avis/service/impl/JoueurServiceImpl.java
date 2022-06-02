package fr.humanbooster.sparks.avis.service.impl;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.dao.JoueurDao;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JoueurServiceImpl implements JoueurService {
	
	private JoueurDao joueurDao;

	@Override
	public Joueur recupererJoueur(String pseudo, String motDePasse) {
		return joueurDao.findByPseudo(pseudo);
	}

	@Override
	public Joueur ajouterJoueur(@Valid Joueur joueur) {
		return joueurDao.save(joueur);
	}

}

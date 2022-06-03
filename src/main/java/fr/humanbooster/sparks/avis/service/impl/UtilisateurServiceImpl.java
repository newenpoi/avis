package fr.humanbooster.sparks.avis.service.impl;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import fr.humanbooster.sparks.avis.dao.UtilisateurDao;
import fr.humanbooster.sparks.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private final UtilisateurDao utilisateurDao;

	@Override
	public Utilisateur recupererUtilisateur(String pseudo, String motDePasse) {
		return utilisateurDao.findByPseudo(pseudo);
	}

}

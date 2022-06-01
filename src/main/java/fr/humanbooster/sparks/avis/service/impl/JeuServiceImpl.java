package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.dao.JeuDao;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JeuServiceImpl implements JeuService {
	
	private JeuDao jeuDao;

	@Override
	public Jeu recupererJeu(Long idJeu) {
		return jeuDao.findById(idJeu).orElse(null);
	}

	@Override
	public List<Jeu> recupererJeux() {
		return jeuDao.findAll();
	}

}

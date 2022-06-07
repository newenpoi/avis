package fr.humanbooster.sparks.avis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.business.Moderateur;
import fr.humanbooster.sparks.avis.dao.AvisDao;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.JeuService;
import fr.humanbooster.sparks.avis.util.Color;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvisServiceImpl implements AvisService {
	
	private AvisDao avisDao;
	private final JeuService jeuService;

	@Override
	public List<Avis> recupererAvis() {
		return avisDao.findAll();
	}

	@Override
	public Avis ajouterAvis(Avis avis) {
		System.out.println(Color.red("Service Save..."));
		return avisDao.save(avis);
	}

	@Override
	public Avis ajouterAvis(Long idJeu, String description, Float note, Joueur joueur) {
		// Jeu jeu = jeuService.recupererJeu(idJeu);
		// if (jeu == null) return null;
		
		Avis avis = new Avis();
		avis.setJeu(jeuService.recupererJeu(idJeu));
		avis.setDescription(description);
		avis.setNote(note);
		
		avis.setDateEnvoi(LocalDateTime.now());
		avis.setJoueur(joueur);
		
		return avisDao.save(avis);
	}

	@Override
	public Page<Avis> recupererAvis(Pageable withPage) {
		return avisDao.findAll(withPage);
	}

	@Override
	public Page<Avis> recupererAvisJoueurConnecte(Pageable withPage, Long idJoueur) {
		return avisDao.findByDateModerationIsNotNullOrDateModerationIsNullAndJoueurIdEquals(withPage, idJoueur);
	}

	@Override
	public Avis recupererAvisUnique(Long idAvis) {
		return avisDao.findById(idAvis).orElse(null);
	}

	@Override
	public void validerAvis(Long idAvis, Moderateur moderateur) {
		Avis avis = avisDao.findById(idAvis).orElse(null);
		
		avis.setDateModeration(LocalDateTime.now());
		avis.setModerateur(moderateur);
		
		avisDao.save(avis);
	}

	@Override
	public void supprimerAvis(Long idAvis) {
		avisDao.deleteById(idAvis);
	}

}

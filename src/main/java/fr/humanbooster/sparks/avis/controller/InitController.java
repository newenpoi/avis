package fr.humanbooster.sparks.avis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import fr.humanbooster.sparks.avis.util.Color;
import fr.humanbooster.sparks.avis.business.Classification;
import fr.humanbooster.sparks.avis.business.Editeur;
import fr.humanbooster.sparks.avis.business.Genre;
import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.business.ModeleEconomique;
import fr.humanbooster.sparks.avis.business.Moderateur;
import fr.humanbooster.sparks.avis.business.PlateForme;
import fr.humanbooster.sparks.avis.dao.ClassificationDao;
import fr.humanbooster.sparks.avis.dao.EditeurDao;
import fr.humanbooster.sparks.avis.dao.GenreDao;
import fr.humanbooster.sparks.avis.dao.JeuDao;
import fr.humanbooster.sparks.avis.dao.JoueurDao;
import fr.humanbooster.sparks.avis.dao.ModeleEconomiqueDao;
import fr.humanbooster.sparks.avis.dao.ModerateurDao;
import fr.humanbooster.sparks.avis.dao.PlateFormeDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InitController implements CommandLineRunner {
	
	private final static Faker faker = new Faker(new Locale("fr-FR"));
	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"), new RandomService());
	private final static Random r = new Random();

	private final EditeurDao editeurDao;
	private final ClassificationDao classificationDao;
	private final GenreDao genreDao;
	private final PlateFormeDao plateFormeDao;
	private final ModeleEconomiqueDao modeleEconomiqueDao;
	private final JoueurDao joueurDao;
	private final ModerateurDao moderateurDao;
	private final JeuDao jeuDao;

	@Override
	public void run(String... args) throws Exception {
		
		// Si aucune données initiales sur les éditeurs.
		if (editeurDao.count() == 0) ajouterEditeurs();
		
		// Si aucune données initiales sur les classifications.
		if (classificationDao.count() == 0) ajouterClassifications();
		
		// Si aucune données initiales sur les genres.
		if (genreDao.count() == 0) ajouterGenres();
		
		// Si aucune données initiales sur les plateformes.
		if (plateFormeDao.count() == 0) ajouterPlateFormes();
		
		// Si aucune données initiales sur les modèles économiques.
		if (modeleEconomiqueDao.count() == 0) ajouterModelesEcos();
		
		// Si aucune données initiales sur les joueurs.
		if (joueurDao.count() == 0) ajouterJoueurs();
		
		// Si aucune données initiales sur les modérateurs.
		if (moderateurDao.count() == 0) ajouterModerateurs();
		
		// Si aucune données initiales concernant les jeux.
		if (jeuDao.count() == 0) {
        	Long elapsed = ajouterJeux(10, System.currentTimeMillis());
        	System.out.printf(Color.green("\nTemps d'exécution d'ajout des données : %d ms.\n"), elapsed);
		}
	}
	
	public void ajouterEditeurs() {
		editeurDao.save(new Editeur("Electronic Arts"));
		editeurDao.save(new Editeur("Gameforge"));
		editeurDao.save(new Editeur("Smilegate"));
		editeurDao.save(new Editeur("Lion Games"));
		editeurDao.save(new Editeur("Rockstar Games"));
		editeurDao.save(new Editeur("Idea Factory"));
		editeurDao.save(new Editeur("Ubisoft"));
	}
	
	public void ajouterClassifications() {
		classificationDao.save(new Classification("PEGI 3"));
		classificationDao.save(new Classification("PEGI 7"));
		classificationDao.save(new Classification("PEGI 12"));
		classificationDao.save(new Classification("PEGI 16"));
		classificationDao.save(new Classification("PEGI 18"));
	}
	
	public void ajouterGenres() {
		genreDao.save(new Genre("Aventure"));
		genreDao.save(new Genre("Action"));
		genreDao.save(new Genre("RPG"));
		genreDao.save(new Genre("Massivement Multijoueur"));
	}
	
	public void ajouterPlateFormes() {
		plateFormeDao.save(new PlateForme("Playstation 4"));
		plateFormeDao.save(new PlateForme("Playstation 5"));
		plateFormeDao.save(new PlateForme("Switch"));
		plateFormeDao.save(new PlateForme("XBOX Series S"));
		plateFormeDao.save(new PlateForme("XBOX Series X"));
		plateFormeDao.save(new PlateForme("Microsoft Windows"));
		plateFormeDao.save(new PlateForme("Mac"));
		plateFormeDao.save(new PlateForme("Android"));
		plateFormeDao.save(new PlateForme("iOS"));
	}
	
	public void ajouterModelesEcos() {
		modeleEconomiqueDao.save(new ModeleEconomique("Free to Play"));
		modeleEconomiqueDao.save(new ModeleEconomique("Pay to Play"));
		modeleEconomiqueDao.save(new ModeleEconomique("Abonnement"));
		modeleEconomiqueDao.save(new ModeleEconomique("Accès Anticipé"));
		modeleEconomiqueDao.save(new ModeleEconomique("Pay What You Want"));
		modeleEconomiqueDao.save(new ModeleEconomique("Play to Earn"));
	}
	
	public void ajouterJoueurs() {
		joueurDao.save(new Joueur("newenpoi", "azerty", "newonche@mdr.fr", LocalDate.of(1991, 12, 9)));
		joueurDao.save(new Joueur("piegeamorue", "logmein", "piegeamorue@mdr.fr", LocalDate.of(1958, 7, 16)));
	}
	
	public void ajouterModerateurs() {
		moderateurDao.save(new Moderateur("roulieauislesgials", "oncheonche", "roulieau@avis.fr", "0768696969"));
		moderateurDao.save(new Moderateur("monsieurburns", "123456789", "monsieurburns@springfield.com", "0125683636"));
	}
	
	public Long ajouterJeux(int limit, Long ms) {
		HashMap<String, Jeu> jeux = new HashMap<String, Jeu>();
		
		for (int i = 0; i < limit; i++) {
			// Déclaration des données fausses.
			String nom = faker.name().lastName();
			String description = faker.lorem().paragraph(2);
			
        	// Refait un tour de boucle si la clé existe déjà.
        	if (jeux.containsKey(nom)) continue;
			
			// Déclaration du jeu.
			Jeu jeu = new Jeu();
			
			jeu.setNom(nom);
			jeu.setDescription(description);
			jeu.setDateSortie(LocalDate.now());
			jeu.setImage("/src/image/image.png");
			
			jeu.setGenre(genreDao.findById(entreeAleatoire(genreDao.count())).orElse(null));
			jeu.setEditeur(editeurDao.findById(entreeAleatoire(editeurDao.count())).orElse(null));
			jeu.setClassification(classificationDao.findById(entreeAleatoire(classificationDao.count())).orElse(null));
			
			// Ajout des plate-formes pour ce jeu.
			ArrayList<PlateForme> plateformes = new ArrayList<>();
			plateformes.add(plateFormeDao.findById(entreeAleatoire(plateFormeDao.count())).orElse(null));
			jeu.setPlateformes(plateformes);
			
			jeu.setModeleEconomique(modeleEconomiqueDao.findById(entreeAleatoire(modeleEconomiqueDao.count())).orElse(null));
			jeu.setModerateur(moderateurDao.findById(entreeAleatoire(moderateurDao.count())).orElse(null));
			
			jeux.put(nom, jeu);
		}
		
    	try {
	    	jeuDao.saveAll(jeux.values());
    	} catch (Exception e) {
    		// Affiche les erreurs récupérées en rouge.
    		System.out.printf(Color.red("\nErreur : %s\n"), e.toString());
    	}
    	
    	return (System.currentTimeMillis() - ms);
	}
	
	public Long entreeAleatoire(Long taille) {
		return r.nextLong(1, taille);
	}
}

package fr.humanbooster.sparks.avis.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.dao.AvisDao;
import fr.humanbooster.sparks.avis.service.CSVExportService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CSVExportServiceImpl implements CSVExportService {
	
	/*
	 * Cette exportation est juste adaptée aux avis.
	 */
	
	private static final Logger logger = LogManager.getLogger(CSVExportService.class);
	private final AvisDao avisDao;

	@Override
	public void ExportCSV(PrintWriter writer) {
		List<Avis> avis = avisDao.findAll();
		
		String[] enTetes = { "ID", "Date Envoi", "Date Modération", "Pseudo", "Jeu" };
		
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(enTetes))) {
			for (Avis avisItem : avis) {
				
				csvPrinter.printRecord(avisItem.getId(), 
						DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(avisItem.getDateEnvoi()), 
						avisItem.getDateModeration(), 
						avisItem.getJoueur().getPseudo(), 
						avisItem.getJeu().getNom());
			}
		} catch (IOException e) {
			logger.error("Désolé, il semblerait qu'on ai quelques difficultés à écrire le fichier CSV...", e);
		}
	}

}

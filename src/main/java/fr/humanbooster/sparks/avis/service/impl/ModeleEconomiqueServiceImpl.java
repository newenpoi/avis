package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.ModeleEconomique;
import fr.humanbooster.sparks.avis.dao.ModeleEconomiqueDao;
import fr.humanbooster.sparks.avis.service.ModeleEconomiqueService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModeleEconomiqueServiceImpl implements ModeleEconomiqueService {

	private final ModeleEconomiqueDao modeleEconomiqueDao;

	@Override
	public List<ModeleEconomique> recupererModelesEconomiques() {
		return modeleEconomiqueDao.findAll();
	}
	
}

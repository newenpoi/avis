package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Editeur;
import fr.humanbooster.sparks.avis.dao.EditeurDao;
import fr.humanbooster.sparks.avis.service.EditeurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EditeurServiceImpl implements EditeurService {

	private final EditeurDao editeurDao;

	@Override
	public List<Editeur> recupererEditeurs() {
		return editeurDao.findAll();
	}
	
}

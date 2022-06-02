package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Classification;
import fr.humanbooster.sparks.avis.dao.ClassificationDao;
import fr.humanbooster.sparks.avis.service.ClassificationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassificationServiceImpl implements ClassificationService {
	
	private final ClassificationDao classificationDao;

	@Override
	public List<Classification> recupererClassifications() {
		return classificationDao.findAll();
	}

}

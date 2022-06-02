package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.PlateForme;
import fr.humanbooster.sparks.avis.dao.PlateFormeDao;
import fr.humanbooster.sparks.avis.service.PlateFormeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlateFormeServiceImpl implements PlateFormeService {
	private final PlateFormeDao plateFormeDao;

	@Override
	public List<PlateForme> recupererPlateformes() {
		return plateFormeDao.findAll();
	}
	
}

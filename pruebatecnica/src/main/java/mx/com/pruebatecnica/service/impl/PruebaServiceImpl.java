/**
 * 
 */
package mx.com.pruebatecnica.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.com.pruebatecnica.model.Estudiante;
import mx.com.pruebatecnica.model.Examen;
import mx.com.pruebatecnica.repository.EstudianteRepository;
import mx.com.pruebatecnica.repository.ExamenRepository;
import mx.com.pruebatecnica.service.IPruebaService;

/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
@Log4j2
@Service
public class PruebaServiceImpl implements IPruebaService {

	@Autowired
	private ExamenRepository examenR;
	
	@Autowired
	private EstudianteRepository estudianteR;
	
	@Override
	public Estudiante saveEstudiante(Estudiante estudiante) {
		log.info("GUARDAR --> {}", estudiante);
		return estudianteR.save(estudiante);
	}

	@Override
	public Examen saveExamen(Examen examen) {
		log.info("GUARDAR --> {}", examen);
		return examenR.save(examen);
	}
	
	@Override
	public Estudiante getEstudiante(int id) {
		log.info("BUSCAR --> {}", id);
		Optional<Estudiante> optional = estudianteR.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			log.info("No existe --> {}", id);
			return null;
		}
	}

	@Override
	public List<Examen> getAllExamen() {
		log.info("SE CONSULTAN TODOS LOS EXAMENES");
		List<Examen> exa = (List<Examen>) examenR.findAll();
		return exa;
	}

}

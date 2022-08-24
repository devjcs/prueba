/**
 * 
 */
package mx.com.pruebatecnica.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.com.pruebatecnica.model.Estudiante;
import mx.com.pruebatecnica.model.Examen;
import mx.com.pruebatecnica.model.Respuestas;
import mx.com.pruebatecnica.service.IPruebaService;

/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
@CrossOrigin(origins = "*" , methods = {RequestMethod.POST})
@RestController
@Log4j2
@RequestMapping(value = "/api/prueba/v1", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class PruebaController {
	@Autowired
	private IPruebaService pruebaService;
	
	@PostMapping("/guardar/estudiante")
	public ResponseEntity<Object> createEstudiante(@RequestBody Estudiante estudiante) {
		try {
//			if (estudiante.getIdEstudiante().isEmpty()) {
				estudiante = pruebaService.saveEstudiante(estudiante);
				if (estudiante != null) {
					return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("Estudiante ya registrado", HttpStatus.CONFLICT);
				}
//			} else {
//				return new ResponseEntity<>("Verifique los campos", HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/guardar/examen")
	public ResponseEntity<Object> createExamen(@RequestBody Examen examen) {
		try {
//			if (estudiante.getIdEstudiante().isEmpty()) {
				examen = pruebaService.saveExamen(examen);
				if (examen != null) {
					return new ResponseEntity<>(examen, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("Examen ya registrado", HttpStatus.CONFLICT);
				}
//			} else {
//				return new ResponseEntity<>("Verifique los campos", HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultar/estudiante")
	public ResponseEntity<Object> consultarEstudiante(@RequestParam (value = "id", required = true) int id) {
		try {
//			if (estudiante.getIdEstudiante().isEmpty()) {
				Estudiante estudiante = pruebaService.getEstudiante(id);
				if (estudiante != null) {
					return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("Estudiante ya registrado", HttpStatus.CONFLICT);
				}
//			} else {
//				return new ResponseEntity<>("Verifique los campos", HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultar/examen")
	public ResponseEntity<Object> consultarExamen() {
		try {
//			if (estudiante.getIdEstudiante().isEmpty()) {
				List<Examen> examen = pruebaService.getAllExamen();
				if (examen != null) {
					return new ResponseEntity<>(examen, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("No cuenta con Examenes registrados", HttpStatus.NOT_FOUND);
				}
//			} else {
//				return new ResponseEntity<>("Verifique los campos", HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultar/fecha/region")
	public ResponseEntity<Object> consultarFecha(@RequestParam (value = "id", required = true) int id) {
		try {
//			if (estudiante.getIdEstudiante().isEmpty()) {
				Estudiante estudiante = pruebaService.getEstudiante(id);
				if (estudiante != null) {
					
					//LocalDate dateExamen = LocalDate.parse("2022-10-10 ");
					
					ZoneId zoneIdColombia = ZoneId.of("America/Bogota");
					ZonedDateTime departureDate = ZonedDateTime.of(2022, 10, 10, 9, 30, 0, 0, zoneIdColombia);
					
					ZoneId zoneIdPais = ZoneId.of(estudiante.getZonahoraria());
					ZonedDateTime departureDate2 = ZonedDateTime.ofInstant(departureDate.plusHours(12).toInstant(), zoneIdPais);
					log.info("Arrival in {} time: {}", estudiante.getZonahoraria(), departureDate2.plusHours(12) );
					
					String mensaje = "\n\t\t\t\t El examen se aplicara a las : "+departureDate+" \n\t\t\t\t Hora local de su pais: "+ departureDate2.plusHours(12)+" ";
					
					
					
					
					return new ResponseEntity<>(mensaje, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("No se encontro ninguna region ligada a ese estudiante", HttpStatus.NOT_FOUND);
				}
//			} else {
//				return new ResponseEntity<>("Verifique los campos", HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/evalua/examen")
	public ResponseEntity<Object> evaluaExamen(@RequestBody List<Respuestas> resp) {
		try {
			
			log.info("respuestas {}",resp);
			
				List<Examen> examen = pruebaService.getAllExamen();
				if (examen != null) {
					/*
					List<String> lista = resp.filter(f -> {
					examen.( e -> e.)
					.contains(f.getIdexamen())).collect(Collectors.toList()
					});
					*/
					
					//List<Respuestas> resp = resp1.stream().distinct().collect(Collectors.toList());
					
					
					List<Respuestas> listOneList = resp.stream().filter(two -> examen.stream()
							.anyMatch(one -> one.getIdexamen()==(two.getIdexamen()) && two.getRespuesta()==(one.getRespuesta())))
							.collect(Collectors.toList());
					log.info(listOneList);
					
					int limit = 100;
					int totalQuest = examen.size();
					int promedio = (limit*listOneList.size())/totalQuest;
					log.info("el promedio es {}", promedio);
					return new ResponseEntity<>("el promedio es "+promedio, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("Examen ya registrado", HttpStatus.CONFLICT);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

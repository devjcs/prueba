/**
 * 
 */
package mx.com.pruebatecnica.service;

import java.util.List;

import mx.com.pruebatecnica.model.Estudiante;
import mx.com.pruebatecnica.model.Examen;

/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
public interface IPruebaService {
	Estudiante saveEstudiante(Estudiante auto);
	Examen saveExamen(Examen auto);
	/**
	 * @param estudiante
	 * @return
	 */
	Estudiante getEstudiante(int id);
	/**
	 * @param examen
	 * @return
	 */
	List<Examen> getAllExamen();

}

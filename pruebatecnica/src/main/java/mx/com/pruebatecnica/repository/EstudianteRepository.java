/**
 * 
 */
package mx.com.pruebatecnica.repository;


import org.springframework.data.repository.CrudRepository;

import mx.com.pruebatecnica.model.Estudiante;


/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {

}

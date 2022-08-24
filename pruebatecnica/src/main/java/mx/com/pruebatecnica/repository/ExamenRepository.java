/**
 * 
 */
package mx.com.pruebatecnica.repository;

import org.springframework.data.repository.CrudRepository;

import mx.com.pruebatecnica.model.Examen;

/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
public interface ExamenRepository extends CrudRepository<Examen, String> {

}

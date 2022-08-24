/**
 * 
 */
package mx.com.pruebatecnica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @description
 * 
 * @project pruebatecnica
 * @author Andrés
 * @created 22 ago. 2022
 * @version 1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Respuestas {
	private int idexamen;
	private int respuesta;
}

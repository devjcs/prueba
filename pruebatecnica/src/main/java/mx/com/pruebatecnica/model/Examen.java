/**
 * 
 */
package mx.com.pruebatecnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "examen")
public class Examen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idexamen;
	@Column
	private String descripcion;
	@Column
	private String column1;
	@Column
	private String column2;
	@Column
	private String column3;
	@Column
	private String column4;
	@Column
	private int respuesta;
}

/**
 * 
 */
package com.salesianostriana.dam.rest.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lucas Amado
 *
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {
	
	@Id @GeneratedValue
	private Long id;
	private String ciudad, latitud, longuitud, nombre, descripcion;
	
	@ManyToOne
	private Pais pais;
	
	@OneToMany (mappedBy="monumento")
	private List<Imagen> listaImagenes;


	public Monumento(String ciudad, String latitud, String longuitud, String nombre, String descripcion) {
		super();
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longuitud = longuitud;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Monumento(String ciudad, String latitud, String longuitud, String nombre, String descripcion, Pais pais) {
		super();
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longuitud = longuitud;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
	}

}

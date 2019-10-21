package com.salesianostriana.dam.rest.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	
	@Id @GeneratedValue
	private Long id;
	private String nombre, codigoIso;

	public Pais(String nombre, String codigoIso) {
		super();
		this.nombre = nombre;
		this.codigoIso = codigoIso;
	}
	
	
}

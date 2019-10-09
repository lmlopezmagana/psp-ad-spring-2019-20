package com.salesianostriana.dam.rest.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Imagen {
	
	@Id @GeneratedValue
	private Long id;
	private String ruta;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Monumento monumento;
	
}

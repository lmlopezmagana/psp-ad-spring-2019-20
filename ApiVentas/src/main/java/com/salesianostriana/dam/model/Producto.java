package com.salesianostriana.dam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private float precio;

}

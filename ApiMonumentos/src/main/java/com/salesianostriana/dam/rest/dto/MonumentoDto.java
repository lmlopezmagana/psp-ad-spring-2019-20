package com.salesianostriana.dam.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Luismi
 */
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class MonumentoDto {
	
	private Long id;
	private String nombre;
	private String loc;
	private String ubicacion;
	private List<String> imagenes;

}

package com.salesianostriana.dam.rest.dto.conversores;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.rest.dto.MonumentoDto;
import com.salesianostriana.dam.rest.modelo.Imagen;
import com.salesianostriana.dam.rest.modelo.Monumento;
/**
 * 
 * @author luismi
 *
 */
@Component
public class MonumentoDtoConverter {
	
	public MonumentoDto convertMonumentoToMonumentoDto(Monumento monumento) {
		
		return MonumentoDto.builder()
					.id(monumento.getId())
					.nombre(monumento.getNombre())
					.loc(monumento.getLatitud()+","+monumento.getLonguitud())
					.ubicacion(monumento.getCiudad()+", " + monumento.getPais().getNombre())
					.imagenes(monumento.getListaImagenes().stream().map(Imagen::getRuta).collect(Collectors.toList()))
					.build();
		
		
	}

}

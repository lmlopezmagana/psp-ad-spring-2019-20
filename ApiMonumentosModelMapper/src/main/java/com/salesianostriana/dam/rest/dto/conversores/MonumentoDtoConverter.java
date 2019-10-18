package com.salesianostriana.dam.rest.dto.conversores;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.rest.dto.MonumentoDto;
import com.salesianostriana.dam.rest.modelo.Imagen;
import com.salesianostriana.dam.rest.modelo.Monumento;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
/**
 * 
 * @author luismi
 *
 */
@Log
@Component
@RequiredArgsConstructor
public class MonumentoDtoConverter {
	
	private final ModelMapper modelMapper;
	
	
	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<Monumento, MonumentoDto>() {

			@Override
			protected void configure() {
				skip().setImagenes(null);
				//map().setLoc(String.format("%s, %s", source.getCiudad(), source.getPais() != null ? source.getPais().getNombre() : null));
			}
			
		});
		
	}
	
	
	public MonumentoDto convertMonumentoToMonumentoDto(Monumento monumento) {
		
		return modelMapper.map(monumento, MonumentoDto.class);
		
		
	}

}

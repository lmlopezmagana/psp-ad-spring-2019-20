package com.salesianostriana.dam.rest.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MonumentoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -140556858545498881L;
	
	
	public MonumentoNotFoundException(Long id) {
		super("No se ha encontrado el monumento con ID: " + id);
	}
	

}

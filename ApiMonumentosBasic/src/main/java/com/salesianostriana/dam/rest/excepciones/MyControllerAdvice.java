package com.salesianostriana.dam.rest.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MonumentoNotFoundException.class)
	public ResponseEntity<?> handleMonumentoNoEncontrado(MonumentoNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Monumento no encontrado", ex);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(status, ex);
		return ResponseEntity.status(status).body(apiError);
	}
	
	

}

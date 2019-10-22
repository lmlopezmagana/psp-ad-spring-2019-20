package com.salesianostriana.dam.error;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4475007554095522837L;
	
	
	public UserNotFoundException() {
		super("Usuario no encontrado");
	}
	
	public UserNotFoundException(String username) {
		super(String.format("Usuario %s no encontrado", username));
	}
	
}

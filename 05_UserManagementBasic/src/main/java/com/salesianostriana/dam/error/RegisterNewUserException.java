package com.salesianostriana.dam.error;

public class RegisterNewUserException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -247355172899421626L;

	public RegisterNewUserException(String mensaje) {
		super(mensaje);
	}

}

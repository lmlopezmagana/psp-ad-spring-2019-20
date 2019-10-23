package com.salesianostriana.dam.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.dto.CreateUserDto;
import com.salesianostriana.dam.dto.EditUserPasswordDto;
import com.salesianostriana.dam.error.RegisterNewUserException;
import com.salesianostriana.dam.error.UserNotFoundException;
import com.salesianostriana.dam.model.UserEntity;
import com.salesianostriana.dam.repository.UserEntityRepository;
import com.salesianostriana.dam.service.base.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

	private final PasswordEncoder passwordEncoder;

	public UserEntity getUserEntityByUsername(String username)  {
		return this.repositorio.findFirstByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
	}

	public UserEntity newUserEntity(CreateUserDto createUserDto) {
		
		// Si las contraseñas están vacías o no son iguales
		if (createUserDto.getPassword().isEmpty() || createUserDto.getPassword2().isEmpty())
			throw new RegisterNewUserException("La contraseña no cumple con la política de seguridad");
		
				
		if (!createUserDto.getPassword().equals(createUserDto.getPassword2())) 
			throw new RegisterNewUserException("Las contraseñas no coinciden");
			
		
		UserEntity newUser = UserEntity.builder()
								.username(createUserDto.getUsername())
								.password(passwordEncoder.encode(createUserDto.getPassword()))
								.avatar(createUserDto.getAvatar())
								//.roles(Set.of("USER")) //Java 9
								.roles(Stream.of("USER").collect(Collectors.toSet()))
								.build();
		
		return this.repositorio.save(newUser);
	}
	
	public UserEntity editUser(EditUserPasswordDto editUserDto, Long userId) {
		
			UserEntity theUser = findById(userId).orElseThrow(()-> new UserNotFoundException());
			
			// Comprobamos si la contraseña actual coincide
			if (!passwordEncoder.matches(editUserDto.getActualPassword(), theUser.getPassword())) {
				throw new RegisterNewUserException("La contraseña no es correcta");
			}
			
			// Si las contraseñas están vacías o no son iguales
			if (editUserDto.getNewPassword().isEmpty() || editUserDto.getNewPassword2().isEmpty())
				throw new RegisterNewUserException("La contraseña no cumple con la política de seguridad");
			
					
			if (!editUserDto.getNewPassword2().equals(editUserDto.getNewPassword2())) 
				throw new RegisterNewUserException("Las contraseñas no coinciden");
		
			theUser.setPassword(passwordEncoder.encode(editUserDto.getNewPassword()));

			return save(theUser);
		
	}

}

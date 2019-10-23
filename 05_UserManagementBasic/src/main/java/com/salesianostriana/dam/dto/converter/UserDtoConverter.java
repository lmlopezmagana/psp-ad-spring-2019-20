package com.salesianostriana.dam.dto.converter;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.dto.UserDto;
import com.salesianostriana.dam.model.UserEntity;

@Component
public class UserDtoConverter {
	
	public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
		return UserDto.builder()
				.username(userEntity.getUsername())
				.avatar(userEntity.getAvatar())
				.roles(userEntity.getRoles())
				.build();
	}
	
	
	

}

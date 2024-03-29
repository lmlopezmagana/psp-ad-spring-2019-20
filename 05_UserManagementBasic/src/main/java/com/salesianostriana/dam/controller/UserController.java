package com.salesianostriana.dam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.dam.dto.CreateUserDto;
import com.salesianostriana.dam.dto.EditUserPasswordDto;
import com.salesianostriana.dam.dto.UserDto;
import com.salesianostriana.dam.dto.converter.UserDtoConverter;
import com.salesianostriana.dam.model.UserEntity;
import com.salesianostriana.dam.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService;
	private final UserDtoConverter userDtoConverter;
	
	@GetMapping("/me")
	public UserDto me(@AuthenticationPrincipal UserEntity user) {
		return userDtoConverter.convertUserEntityToUserDto(user);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody CreateUserDto createUserDto) {
		
		UserEntity user = userEntityService.newUserEntity(createUserDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDtoConverter.convertUserEntityToUserDto(user));
		
		
	}
	
	@PutMapping("/edit")
	public UserDto edit(@AuthenticationPrincipal UserEntity user, EditUserPasswordDto editUserDto) {
		return userDtoConverter
				.convertUserEntityToUserDto(
						userEntityService.editUser(editUserDto, user.getId()));
	}
	
	
}

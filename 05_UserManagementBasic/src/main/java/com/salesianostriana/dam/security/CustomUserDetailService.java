package com.salesianostriana.dam.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

	private final UserEntityService userEntityService;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userEntityService.getUserEntityByUsername(username);
//		UserEntity user = userEntityService.getUserEntityByUsername(username);
//		
//		return User.builder()
//			.username(user.getUsername())
//			.password(user.getPassword())
//			.authorities(
//					user.getRoles().stream()
//						.map(SimpleGrantedAuthority::new)
//						.collect(Collectors.toList())						
//			)
//			.build();
			
		
	}

}

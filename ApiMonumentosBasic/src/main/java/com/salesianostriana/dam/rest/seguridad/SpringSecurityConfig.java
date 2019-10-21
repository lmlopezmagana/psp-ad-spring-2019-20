package com.salesianostriana.dam.rest.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			httpBasic()
			.authenticationEntryPoint(authenticationEntryPoint)	
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/monumentos/**").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/monumento/").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/monumentos/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/monumentos/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.csrf().disable();
			
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN")
			.and().withUser("user").password("{noop}user").roles("USER");
	}
	


	

	
	
	
	
}

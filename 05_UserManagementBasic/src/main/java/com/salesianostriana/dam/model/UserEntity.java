package com.salesianostriana.dam.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserEntity {

	@Id @GeneratedValue
	private Long id;
	
	private String username;
	
	private String password;
	
	private String avatar;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@Builder.Default
	private LocalDateTime lastPasswordChangedAt = LocalDateTime.now();

}

package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @EqualsAndHashCode(exclude="lineasDeVenta") 
@NoArgsConstructor @AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Venta {
	
	@Id @GeneratedValue
	private Long id;
	
	@CreatedDate
	private LocalDate fecha;
	
	private String cliente;
	
	@OneToMany(mappedBy="venta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<LineaVenta> lineasDeVenta = new HashSet<>();
	
	
	/**
	 * Métodos helper
	 */
	public void addLineaVenta(LineaVenta lv) {
		lineasDeVenta.add(lv);
		lv.setVenta(this);
	}
	
	
	public void removeLineaVenat(LineaVenta lv) {
		lineasDeVenta.remove(lv);
		lv.setVenta(null);
	}

}
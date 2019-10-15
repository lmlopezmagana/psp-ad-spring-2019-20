package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.service.ProductoServicio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producto/")
@RequiredArgsConstructor
public class ProductoController {
	
	private final ProductoServicio productoServicio;
	
	@GetMapping("/")
	public List<Producto> index() {
		return productoServicio.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Producto unProducto(@PathVariable Long id) {
		return productoServicio.findById(id).orElse(null);
	}

	@PostMapping("/")
	public Producto nuevoProducto(@RequestBody Producto producto) {
		return productoServicio.save(producto);
	}

	@PutMapping("/{id}")
	public Producto editarProducto(@PathVariable Long id, @RequestBody Producto producto) {
		return productoServicio.findById(id)
				.map(p -> {
					p.setNombre(producto.getNombre());
					p.setPrecio(producto.getPrecio());
					return productoServicio.save(p);
				}).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void borrarProducto(@PathVariable Long id) {
		productoServicio.deleteById(id);
	}
	

}

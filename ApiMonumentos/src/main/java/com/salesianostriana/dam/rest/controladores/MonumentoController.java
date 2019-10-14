/**
 * 
 */
package com.salesianostriana.dam.rest.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.salesianostriana.dam.rest.dto.MonumentoDto;
import com.salesianostriana.dam.rest.dto.conversores.MonumentoDtoConverter;
import com.salesianostriana.dam.rest.excepciones.MonumentoNotFoundException;
import com.salesianostriana.dam.rest.modelo.Monumento;
import com.salesianostriana.dam.rest.repos.MonumentoRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Lucas Amado
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumentos")
public class MonumentoController {
	
	private final MonumentoRepository monumentoRepository;
	private final MonumentoDtoConverter monumentoDtoConverter;
	
	@GetMapping("/")
	public ResponseEntity<?> index(){
		List<Monumento> result = monumentoRepository.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			
			List<MonumentoDto> dtoList = 
					result.stream()
						.map(monumentoDtoConverter::convertMonumentoToMonumentoDto)
						.collect(Collectors.toList());
			
			return ResponseEntity.ok(dtoList);
		}
		
	}
	
	
	@GetMapping("/{id}")
	public Monumento unMonumento (@PathVariable Optional<Long> id) {
		Long theId = id.orElse(-1L);
//		Monumento monumento = monumentoRepository.findById(theId).orElse(null);
//		if(monumento==null) {
//			//return ResponseEntity.notFound().build();
//			throw new MonumentoNotFoundException(theId);
//		}else {
//			return ResponseEntity.ok(monumento);
//		}
		
		return monumentoRepository.findById(theId)
				.orElseThrow(() -> 
					new MonumentoNotFoundException(theId));
		
		
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> nuevoMonumento (@RequestBody Monumento monumento) {
		Monumento mon = monumentoRepository.save(monumento);
		return new ResponseEntity<Monumento>(mon, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<?> editarMonumento (@PathVariable Optional<Long> id, @RequestBody Monumento monumento) {
		Long theId = id.orElse(-1L);
		return monumentoRepository.findById(theId).map(m -> {
			m.setCiudad(monumento.getCiudad());
			m.getPais().setCodigoIso(monumento.getPais().getCodigoIso());
			m.getPais().setNombre(monumento.getPais().getNombre());
			m.setDescripcion(monumento.getDescripcion());
			m.setLatitud(monumento.getLatitud());
			m.setLonguitud(monumento.getLonguitud());
			m.setNombre(monumento.getNombre());
			m.setPais(monumento.getPais());
			m.setListaImagenes(monumento.getListaImagenes());
			
			return ResponseEntity.ok(monumentoRepository.save(m));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMonumento(@PathVariable Optional<Long> id) {
		Long theId = id.orElse(-1L);
		Monumento m = monumentoRepository.findById(theId).orElse(null);
		
		if(m==null) {
			return ResponseEntity.notFound().build();
		}else {
			monumentoRepository.delete(m);
			return ResponseEntity.noContent().build();
		}
		
	}

}

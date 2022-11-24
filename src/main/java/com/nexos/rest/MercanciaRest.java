package com.nexos.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.service.MercanciaService;

@RestController
@RequestMapping("/Mercancia/")
public class MercanciaRest {

	@Autowired
	private MercanciaService mercanciaService;

	@GetMapping("/listar")
	private ResponseEntity<List<Mercancia>> listarMercancia(){
		return ResponseEntity.ok(mercanciaService.getAllMercancia());
	}
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<Mercancia>> buscarMercanciaById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(mercanciaService.findById(id));
	}
	
	@GetMapping("/BuscarPorNombre/{nombre}")
	private ResponseEntity<List<Mercancia>> buscarMercanciaByNombre(@PathVariable String nombre){
		return ResponseEntity.ok(mercanciaService.findByNombre(nombre));
	}

	@PostMapping("/CrearMercancia")
	private ResponseEntity<MercanciaDTO> saveMercancia (@RequestBody MercanciaDTO mercanciaDto) {
		try {
			MercanciaDTO mercanciaGuardada = mercanciaService.save(mercanciaDto);
			return ResponseEntity.created(new URI("Mercancia/" + mercanciaGuardada.getId())).body(mercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "/updateMercancia")
	public ResponseEntity<Object> updateMercancia(@RequestBody MercanciaDTO mercanciaDto) {
		this.mercanciaService.updateMercanciaDTO(mercanciaDto);
		return ResponseEntity.ok(Boolean.TRUE);
	
	}
	
	@DeleteMapping(value = "/deleteMercancia/{id}/{id_empleado}")
	public ResponseEntity<?> deleteMercancia(@PathVariable(value = "id") Long id, @PathVariable(value = "id_empleado") Long id_empleado ) {
		mercanciaService.deleteById(id, id_empleado);
		return ResponseEntity.ok().build();
	}
}
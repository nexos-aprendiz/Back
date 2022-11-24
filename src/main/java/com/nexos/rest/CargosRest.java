package com.nexos.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;
import com.nexos.service.CargosService;

@RestController
@RequestMapping ("/Cargos")
public class CargosRest {

	@Autowired
	private CargosService cargosService;
	
	@GetMapping("/Listar")
	private ResponseEntity<List<Cargos>> listarCargos (){
		return ResponseEntity.ok(cargosService.getAllCargos());
	}	
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<Cargos>> buscarCargosById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(cargosService.findById(id));
	}
	
	@GetMapping("/BuscarPorCargos/{cargo}")
	private ResponseEntity<List<Cargos>> buscarCargoByCargo(@PathVariable String cargo){
		return ResponseEntity.ok(cargosService.findByCargo(cargo));
	}
	
	@PostMapping("/CrearCargos")
	private ResponseEntity<CargosDTO> saveCargos(@RequestBody CargosDTO cargosDTO) {;
		try {
			CargosDTO cargosGuardado = cargosService.save(cargosDTO);
			return ResponseEntity.created(new URI("/Cargos/" + cargosGuardado.getCargo())).body(cargosGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}

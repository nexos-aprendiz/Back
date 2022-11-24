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

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;
import com.nexos.service.EmpleadoService;


@RestController
@RequestMapping("/Empleado/")
public class EmpleadoRest {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/Listar")
	private ResponseEntity<List<Empleado>> listarEmpleados() {
		return ResponseEntity.ok(empleadoService.getAllEmpleados());
	}
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<Empleado>> buscarEmpleadoById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(empleadoService.findById(id));
	}
	
	@GetMapping("/BuscarPorApellido/{apellido}")
	private ResponseEntity<List<Empleado>> buscarEmpleadoByApellido(@PathVariable String apellido){
		return ResponseEntity.ok(empleadoService.findByApellido(apellido));
	}

	@PostMapping("/CrearEmpleado")
	private ResponseEntity<EmpleadoDTO> saveEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
		try {
			EmpleadoDTO empleadoGuardado = empleadoService.save(empleadoDTO);
			empleadoGuardado.setFecha_ingreso_empresa(empleadoDTO.getFecha_ingreso_empresa());
			return ResponseEntity.created(new URI("/Empleado/" + empleadoGuardado.getId())).body(empleadoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
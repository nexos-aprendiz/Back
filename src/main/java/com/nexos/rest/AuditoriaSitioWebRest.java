package com.nexos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.service.AuditoriaSitioWebService;


@RestController
@RequestMapping("/AuditoriaSitioWeb")
public class AuditoriaSitioWebRest {
	
	@Autowired
	private AuditoriaSitioWebService AuditoriaSitioWebService;
	
	@GetMapping("/listar")
	private ResponseEntity<List<AuditoriaSitioWebDTO>> listarHistorialMercancia() {
		return ResponseEntity.ok(AuditoriaSitioWebService.getAllHistorialMercancia());
	}
	
}

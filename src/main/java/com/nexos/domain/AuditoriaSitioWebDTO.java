package com.nexos.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaSitioWebDTO {
	
	private Long id; 
	private String nombre_empleado;
	private String nombre_mercancia;
	private LocalDate fecha;
	private String operacion;

}

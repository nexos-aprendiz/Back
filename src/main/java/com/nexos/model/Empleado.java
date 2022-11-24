package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empleado_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "id_cargo")
	private Long id_cargo;
	
	@Column(name = "fecha_ingreso_empresa")
	private String fecha_ingreso_empresa;
	
		
	public Empleado (Long id) {
		this.id = id;
	}
	
	public Empleado(Long id, String nombre, String apellido, int edad, long id_cargo, String fecha_ingreso_empresa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id_cargo = id_cargo;
		this.fecha_ingreso_empresa = fecha_ingreso_empresa;
	}

	public Empleado() {
	}

	
}
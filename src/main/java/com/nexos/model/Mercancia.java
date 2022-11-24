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
@Builder
@Entity
@Table(name = "MERCANCIA")
public class Mercancia implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "mercancia_id_seq")
	@Column(name = "id")
	private Long Id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cantidad")
	private String cantidad;
	
	@Column(name = "fecha_ingreso")
	private String fecha_ingreso;
		
	@Column(name = "id_empleado")
	private Long id_empleado;
	//private Empleado id_empleado;
	
	@Column(name = "fecha_modificacion")
	private String fecha_modificacion;

	public Mercancia() {
		
	}

	public Mercancia(Long id, String nombre, String cantidad, String fecha_ingreso, Long id_empleado2,
			String fecha_modificacion) {
		super();
		Id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fecha_ingreso = fecha_ingreso;
		this.id_empleado = id_empleado2;
		this.fecha_modificacion = fecha_modificacion;
	}
	
}
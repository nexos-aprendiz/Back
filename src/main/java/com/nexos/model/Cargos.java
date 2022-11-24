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
import lombok.Getter;

@Data
@Builder
@Getter
@Entity
@Table(name = "CARGOS")
public class Cargos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cargos_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "cargo")
	private String cargo;
	
	public Cargos() {}
	
	public Cargos(Long id, String cargo) {
		super();
		this.id = id;
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Cargos [id=" + id + ", cargo=" + cargo + "]";
	}
	
}
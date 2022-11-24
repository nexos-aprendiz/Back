package com.nexos.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auditoria_sitio_web")
public class AuditoriaSitioWeb implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "auditoriasitioweb_id_seq")
  @Column(name = "id")
  private Long id;

  @Column(name = "nombre_empleado")
  private String nombre_empleado;

  @Column(name = "nombre_mercancia")
  private String nombre_mercancia;

  @Column(name = "fecha")
  private LocalDate fecha;
  
  @Column(name = "operacion")
  private String operacion;

}

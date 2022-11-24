package com.nexos.service;

import java.util.List;

import com.nexos.domain.AuditoriaSitioWebDTO;
public interface AuditoriaSitioWebService {
    
    public List<AuditoriaSitioWebDTO> getAllHistorialMercancia();
	void save(String nombre_empleado, String nombre_mercancia, String operacion);
    void updateMercancia(String nombre_empleado, String nombre_mercancia, String operacion);
  
}
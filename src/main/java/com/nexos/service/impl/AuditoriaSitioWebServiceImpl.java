package com.nexos.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.AuditoriaSitioWeb;
import com.nexos.repository.AuditoriaSitioWebRepository;
import com.nexos.service.AuditoriaSitioWebService;

@Service
@Transactional
public class AuditoriaSitioWebServiceImpl implements AuditoriaSitioWebService {

  @Autowired
  private AuditoriaSitioWebRepository AuditoriaSitioWebRepository;
  
  @Override
  public List<AuditoriaSitioWebDTO> getAllHistorialMercancia() {
    List<AuditoriaSitioWeb> auditoriaSitioWeb = AuditoriaSitioWebRepository.getAllHistorialMercancia();
    return auditoriaSitioWeb.stream().map(item -> {
      return AuditoriaSitioWebDTO.builder()
          .id(item.getId())
          .nombre_empleado(item.getNombre_empleado())
          .fecha(item.getFecha())
          .operacion(item.getOperacion())
          .nombre_mercancia(item.getNombre_mercancia()).build();
    }).collect(Collectors.toList());
  }
  
  @Override
  public void save(String nombre_empleado, String nombre_mercancia, String operacion) {
    AuditoriaSitioWeb auditoriaSitioWeb = new AuditoriaSitioWeb(null, nombre_empleado, nombre_mercancia, LocalDate.now(), operacion);
    AuditoriaSitioWebRepository.save(auditoriaSitioWeb);
  }
  
  @Override
  public void updateMercancia (String nombre_empleado, String nombre_mercancia, String operacion) {
      AuditoriaSitioWeb auditoriaSitioWeb = new AuditoriaSitioWeb(null, nombre_empleado, nombre_mercancia, LocalDate.now(), operacion);
      AuditoriaSitioWebRepository.save(auditoriaSitioWeb);
  }

  
}
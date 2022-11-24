package com.nexos.translator;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.AuditoriaSitioWeb;
import org.springframework.stereotype.Component;


@Component
public class TranslateAuditoriaSitioWeb implements Translator<AuditoriaSitioWebDTO, AuditoriaSitioWeb> {

  @Override
  public AuditoriaSitioWeb translate(AuditoriaSitioWebDTO auditoriaSitioWebDTO) {

    return AuditoriaSitioWeb.builder()
        .id(auditoriaSitioWebDTO.getId())
        .nombre_empleado(auditoriaSitioWebDTO.getNombre_empleado())
        .fecha(auditoriaSitioWebDTO.getFecha())
        .operacion(auditoriaSitioWebDTO.getOperacion())
        .nombre_mercancia(auditoriaSitioWebDTO.getNombre_mercancia()).build();
  }

}

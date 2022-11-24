package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.AuditoriaSitioWeb;


@Component
public class TranslateAuditoriaSitioWebDTO implements Translator<AuditoriaSitioWeb, AuditoriaSitioWebDTO> {

	@Override
	public AuditoriaSitioWebDTO translate(AuditoriaSitioWeb auditoriaSitioWeb) {

		return AuditoriaSitioWebDTO.builder()
				.id(auditoriaSitioWeb.getId())
				.nombre_empleado(auditoriaSitioWeb.getNombre_empleado())
				.fecha(auditoriaSitioWeb.getFecha())
				.operacion(auditoriaSitioWeb.getOperacion())
				.nombre_mercancia(auditoriaSitioWeb.getNombre_mercancia()).build();
	}

}

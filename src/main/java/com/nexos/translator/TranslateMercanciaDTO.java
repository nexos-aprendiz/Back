package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

@Component
public class TranslateMercanciaDTO implements Translator<Mercancia, MercanciaDTO> {

	@Override
	public MercanciaDTO translate(Mercancia mercancia) {
		
	    return MercanciaDTO.builder()
	            .Id(mercancia.getId())
	            .cantidad(mercancia.getCantidad())
	            .nombre(mercancia.getNombre())
	            .fecha_ingreso(mercancia.getFecha_ingreso())
	            .id_empleado(mercancia.getId_empleado())
	            .fecha_modificacion(mercancia.getFecha_modificacion())
	            .build();
	      }

}

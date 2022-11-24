package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

@Component
public class TranslateMercanciaDTO implements Translator<Mercancia, MercanciaDTO> {

	@Override
	public MercanciaDTO translate(Mercancia mercancia) {
		
		MercanciaDTO input = new MercanciaDTO();
		input.setId(mercancia.getId());
		input.setNombre(mercancia.getNombre());
		input.setCantidad(mercancia.getCantidad());
		input.setFecha_ingreso(mercancia.getFecha_ingreso());
		input.setId_empleado(mercancia.getId_empleado());
		input.setFecha_modificacion(mercancia.getFecha_modificacion());
		return input;
	}

}

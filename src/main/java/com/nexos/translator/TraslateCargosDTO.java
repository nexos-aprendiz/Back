package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;

@Component
public class TraslateCargosDTO implements Translator<Cargos, CargosDTO> {

	@Override
	public CargosDTO translate(Cargos cargos) {
		
		return CargosDTO.builder()
				.id(cargos.getId())
				.cargo(cargos.getCargo())
				.build();
	}
}
package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;

@Component
public class TraslateCargosDTO implements Translator<Cargos, CargosDTO> {

	@Override
	public CargosDTO translate(Cargos cargos) {
		
		CargosDTO imput = new CargosDTO();
		imput.setId(cargos.getId());
		imput.setCargo(cargos.getCargo());
		return imput;
	}
}
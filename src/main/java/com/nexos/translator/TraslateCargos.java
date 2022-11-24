package com.nexos.translator;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;
import org.springframework.stereotype.Component;

/**
 * @author erodriguez
 */
@Component
public class TraslateCargos implements Translator<CargosDTO, Cargos> {

	@Override
	public Cargos translate(CargosDTO cargosDTO) {
		
		return Cargos.builder()
				.id(cargosDTO.getId())
				.cargo(cargosDTO.getCargo())
				.build();
	}
}
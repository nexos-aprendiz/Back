package com.nexos.translator;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import org.springframework.stereotype.Component;

/**
 * @author erodriguez
 */
@Component
public class TranslateMercancia implements Translator<MercanciaDTO, Mercancia> {

  @Override
  public Mercancia translate(MercanciaDTO mercanciaDTO) {

    return Mercancia.builder()
        .Id(mercanciaDTO.getId())
        .cantidad(mercanciaDTO.getCantidad())
        .nombre(mercanciaDTO.getNombre())
        .fecha_ingreso(mercanciaDTO.getFecha_ingreso())
        .id_empleado(mercanciaDTO.getId_empleado())
        .fecha_modificacion(mercanciaDTO.getFecha_modificacion())
        .build();
  }

}

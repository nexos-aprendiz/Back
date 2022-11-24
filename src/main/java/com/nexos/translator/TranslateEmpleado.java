package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

@Component
public class TranslateEmpleado implements Translator<EmpleadoDTO, Empleado> {

  @Override
  public Empleado translate(EmpleadoDTO empleadoDTO) {

	  return Empleado.builder()
			  .id(empleadoDTO.getId())
			  .nombre(empleadoDTO.getNombre())
			  .apellido(empleadoDTO.getApellido())
			  .edad(empleadoDTO.getEdad())
			  .id_cargo(empleadoDTO.getId_cargo())
			  .fecha_ingreso_empresa(empleadoDTO.getFecha_ingreso_empresa())
			  .build();
  }
}

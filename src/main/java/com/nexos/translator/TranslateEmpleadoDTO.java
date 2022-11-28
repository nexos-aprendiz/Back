package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

@Component
public class TranslateEmpleadoDTO implements Translator<Empleado, EmpleadoDTO> {

  @Override
  public EmpleadoDTO translate(Empleado empleado) {

	  return EmpleadoDTO.builder()
			  .id(empleado.getId())
			  .nombre(empleado.getNombre())
			  .apellido(empleado.getApellido())
			  .edad(empleado.getEdad())
			  .id_cargo(empleado.getId_cargo())
			  .email(empleado.getEmail())
			  .password(empleado.getPassword())
			  .fecha_ingreso_empresa(empleado.getFecha_ingreso_empresa())
			  .build();
  }
}

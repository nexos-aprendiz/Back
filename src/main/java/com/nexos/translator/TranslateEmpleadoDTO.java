package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

@Component
public class TranslateEmpleadoDTO implements Translator<Empleado, EmpleadoDTO> {

  @Override
  public EmpleadoDTO translate(Empleado empleado) {

    EmpleadoDTO input = new EmpleadoDTO();
    input.setId(empleado.getId());
    input.setNombre(empleado.getNombre());
    input.setApellido(empleado.getApellido());
    input.setEdad(empleado.getEdad());
    input.setId_cargo(empleado.getId_cargo());
    input.setFecha_ingreso_empresa(empleado.getFecha_ingreso_empresa());
    return input;
  }
}

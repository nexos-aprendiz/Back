package com.nexos.service;

import com.nexos.model.Empleado;

public interface AuthService {

  /**
   * Atencicacion de Empleado con los
   * @param username
   * @param password
   * @return Objeto Empleado
   */
  Empleado authEmpleado (String username, String password);

}

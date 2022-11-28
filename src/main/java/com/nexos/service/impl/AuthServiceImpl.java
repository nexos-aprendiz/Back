package com.nexos.service.impl;

import com.nexos.model.Empleado;
import com.nexos.repository.EmpleadoRepository;
import com.nexos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
	
  @Autowired
  EmpleadoRepository empleadoRepository;
  
  @Override
  public Empleado authEmpleado(String username, String password) {
    return empleadoRepository.findByUsernameAndPassword(username, password);
  }
}

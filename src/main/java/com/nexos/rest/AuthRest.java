package com.nexos.rest;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/authentication")
public class AuthRest {

  @Autowired AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<EmpleadoDTO> login
  (@Valid @RequestParam(value = "username", required = true) final String username,
		  @RequestParam(value = "password", required = true) final String password) {
    try {
      authService.authEmpleado(username, password);
      return new ResponseEntity<EmpleadoDTO>(HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

  }
}

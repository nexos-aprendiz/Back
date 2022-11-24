package com.nexos.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;
import com.nexos.repository.EmpleadoRepository;
import com.nexos.service.EmpleadoService;
import com.nexos.translator.TranslateEmpleado;
import com.nexos.translator.TranslateEmpleadoDTO;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
    
    @Autowired
    private TranslateEmpleado translatEmpleado;
    
    @Autowired
    private TranslateEmpleadoDTO translatEmpleadoDTO;
    
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}
	
	@Override
	public Optional<Empleado> findById(Long id) {
		return empleadoRepository.findById(id);
	}
	
	@Override
	public Empleado create (Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Override
	public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
	    return translatEmpleadoDTO.translate(empleadoRepository.save(translatEmpleado.translate(empleadoDTO)));
	}
	
	@Override
	public List<Empleado> findByApellido(String apellido) {
		return empleadoRepository.findByApellidoContainingIgnoreCase(apellido);
	}
}

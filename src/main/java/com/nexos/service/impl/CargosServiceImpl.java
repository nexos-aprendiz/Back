package com.nexos.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;
import com.nexos.repository.CargosRepository;
import com.nexos.service.CargosService;
import com.nexos.translator.TraslateCargos;
import com.nexos.translator.TraslateCargosDTO;

@Service
@Transactional
public class CargosServiceImpl implements CargosService{
    
    @Autowired
    private TraslateCargos translatCargos;
    
    @Autowired
    private TraslateCargosDTO translatCargosDTO;
	
	@Autowired
	private CargosRepository cargosRepository;
	
	@Override
	public List<Cargos> getAllCargos() {
		return cargosRepository.findAll();
	}
	
	@Override
	public Optional<Cargos> findById(Long id) {
		return cargosRepository.findById(id);
	}
	
	@Override
	public Cargos create (Cargos cargos) {
		return cargosRepository.save(cargos);
	}

	@Override
	public CargosDTO save(CargosDTO cargosDTO) {
	    return translatCargosDTO.translate(cargosRepository.save(translatCargos.translate(cargosDTO)));
	}
	
	@Override
	public List<Cargos> findByCargo(String cargo) {
		return cargosRepository.findByCargoContainingIgnoreCase(cargo);
	}

}

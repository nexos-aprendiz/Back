package com.nexos.service;

import java.util.List;
import java.util.Optional;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;

public interface CargosService {
	
	public List<Cargos> getAllCargos ();
	public Cargos create (Cargos cargos);
	public CargosDTO save(CargosDTO cargosDTO);
	public Optional<Cargos> findById(Long id);
	public List<Cargos> findByCargo(String cargo);
}

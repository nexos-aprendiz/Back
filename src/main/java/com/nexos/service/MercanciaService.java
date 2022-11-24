package com.nexos.service;

import java.util.List;
import java.util.Optional;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

public interface MercanciaService {

	Mercancia create (Mercancia mercancia);
	List<Mercancia> findAll();
	List<Mercancia> getAllMercancia();
	MercanciaDTO save(MercanciaDTO mercanciaDto);
	Boolean deleteById(Long id);
	void delete(Mercancia entity);
	void deleteById(long id, Long idEmpleado);
	public MercanciaDTO updateMercanciaDTO (MercanciaDTO mercanciaDTO);
	Optional<Mercancia> findById(Long id);
	List<Mercancia> findByNombre(String nombre);
	
}


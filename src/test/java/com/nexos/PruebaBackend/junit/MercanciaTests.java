package com.nexos.PruebaBackend.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nexos.model.Mercancia;
import com.nexos.repository.MercanciaRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MercanciaTests {
	
	@Autowired
	private MercanciaRepository repository;
	
	@Test
	@Rollback(false)
	public void saveBitagoraTest() {
		Mercancia bitagora = new Mercancia ();
		Mercancia bitagoraSaveTest = repository.save(bitagora);
		
		assertNotNull(bitagoraSaveTest);
	}
	
	@Test
	public void listMercanciaTest (){
		List<Mercancia> id = (List<Mercancia>) repository.findAll();
		
		for (Mercancia bitagora : id) {
			System.out.println(bitagora);
		}
		assertThat(id).size().isGreaterThan(0);
	}
	
	
	//@Test
	public void buscarBitagoraTest() {
		long id = 7;
		Optional<Mercancia> bitagora = repository.findById(id);
	     assertThat(bitagora.get());
	}
	
	//@Test
	public void buscarBitagoraNoExisteTest() {
		long id = 17;
		Optional<Mercancia> bitagora = repository.findById(id);
	     assertNull(bitagora);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void updateBitagoraTest() {
		long id = 13;
		String nombre = "Bomba de aceite";
		String cantidad = "34";
		String fecha_ingreso = "2022-04-06";
		Long id_empleado = (long) 12;
		String fecha_modificacion = "2022-09-20";
		Mercancia bitagora = new Mercancia (null, nombre, cantidad, fecha_ingreso, id_empleado, fecha_modificacion);
		bitagora.setId(id);
		
		repository.save(bitagora);
		Optional<Mercancia> updateBitagora = repository.findById(id);
		assertThat(updateBitagora.get().equals(id));
	}
	
	//@Test
	//@Rollback(false)
	public void deleteBitagoraTest() {
		long id = 15;
		boolean existeAntesDeEliminar = repository.findById(id).isPresent();
		repository.deleteById(id);
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(existeAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
	}

}

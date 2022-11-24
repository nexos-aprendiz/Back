package com.nexos.PruebaBackend.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nexos.model.Cargos;
import com.nexos.repository.CargosRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CargosTests {
	
	private static final Long String = null;
	@Autowired
	private CargosRepository repository;
	
	@Test
	@Rollback(false)
	public void saveCargosTest() {
		Cargos cargos = new Cargos (String, "Gerente de proyectos");
		Cargos cargosSaveTest = repository.save(cargos);
		
		assertNotNull(cargosSaveTest);
	}
	
	@Test
	public void buscarCargoTest() {
		long id = 7;
		Optional<Cargos> cargos = repository.findById(id);
		assertThat(cargos.get());
	}
	
	//@Test
	public void buscarCargosNoExisteTest() {
		long id = 16;
		Optional<Cargos> cargos = repository.findById(id);
		assertNull(cargos);
	}
	
	@Test
	public void listCargosTest (){
		List<Cargos> id = (List<Cargos>) repository.findAll();
		
		for (Cargos cargos : id) {
			System.out.println(cargos);
		}
		assertThat(id).size().isGreaterThan(0);
	}
	
}

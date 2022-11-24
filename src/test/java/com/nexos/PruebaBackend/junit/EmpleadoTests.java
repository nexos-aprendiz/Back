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

import com.nexos.model.Empleado;
import com.nexos.repository.EmpleadoRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmpleadoTests {
	
	
	@Autowired
	private EmpleadoRepository repository;
	
	@Test
	@Rollback(false)
	public void saveEmpleadoTest() {
		Empleado empleado = new Empleado ();
		Empleado saveEmpleadoTest = repository.save(empleado);
		
		assertNotNull(saveEmpleadoTest);
	}
	
	@Test
	public void buscarEmpleadoTest() {
		long id = 7;
		Optional<Empleado> empleado = repository.findById(id);
		assertThat(empleado.get());
	}
	
	//@Test
	public void buscarEmpleadoNoExisteTest() {
		long id = 16;
		Optional<Empleado> empleado = repository.findById(id);
		assertNull(empleado);
	}
	
	@Test
	public void listEmpleadoTest (){
		List<Empleado> id = (List<Empleado>) repository.findAll();
		
		for (Empleado empleado : id) {
			System.out.println(empleado);
		}
		assertThat(id).size().isGreaterThan(0);
	}
}

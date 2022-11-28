package com.nexos.repository;

import java.util.List;

import com.nexos.domain.EmpleadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Query("select p from Empleado p where p.nombre like %?1%")
	List<Empleado> findByApellidoLike(String apellido);
	
	List<Empleado> findByApellidoContainingIgnoreCase(String apellido);

	@Query("select p from Empleado p where p.email = ?1 and p.password = ?1")
	Empleado findByUsernameAndPassword(String username, String password);

}

package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nexos.model.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Long>{
	
	@Query("select p from Cargos p where p.cargo like %?1%")
	List<Cargos> findByCargoLike(String cargo);
	
	List<Cargos> findByCargoContainingIgnoreCase(String cargo);

}
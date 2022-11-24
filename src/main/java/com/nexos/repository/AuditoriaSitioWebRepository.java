package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.model.AuditoriaSitioWeb;

@Repository
public interface AuditoriaSitioWebRepository extends JpaRepository<AuditoriaSitioWeb, Long> {
	
	@Query(value = "SELECT * FROM auditoria_sitio_web", nativeQuery=true)
	List<AuditoriaSitioWeb> getAllHistorialMercancia();

}
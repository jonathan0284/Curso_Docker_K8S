package com.sunat.pe.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunat.pe.app.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
	boolean existsByNombre(String nombre);
	
	boolean existsByCodigo(String codigo);
	
	List<Evento> findByCodigo(String codigo);
	
}
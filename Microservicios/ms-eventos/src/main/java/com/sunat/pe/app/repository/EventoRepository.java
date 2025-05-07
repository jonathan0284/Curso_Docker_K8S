package com.sunat.pe.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunat.pe.app.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
	boolean existsByNombre(String nombre);
	
	boolean existsByCodigo(String codigo);
	
}
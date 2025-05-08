package com.sunat.pe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunat.pe.app.entities.Evento;
import com.sunat.pe.app.service.IEventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	@Autowired
	private IEventoService eventoService;

	@GetMapping
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Evento> obtenerPorId(@PathVariable Long id) {
		return eventoService.obtenerPorId(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Evento> crear(@RequestBody Evento evento) {
		return ResponseEntity.ok(eventoService.guardar(evento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento) {
		return ResponseEntity.ok(eventoService.actualizar(id, evento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		eventoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}

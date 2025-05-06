package com.netec.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.app.entities.Deseo;
import com.netec.app.service.IDeseoService;

@RestController
@RequestMapping("/deseos")
public class DeseoController {

	private final IDeseoService deseoService;

	public DeseoController(IDeseoService deseoService) {
		this.deseoService = deseoService;
	}

	@GetMapping
	public ResponseEntity<List<Deseo>> listarDeseos() {
		return ResponseEntity.ok(deseoService.listarDeseos());
	}

	@PostMapping("/{idProducto}")
	public ResponseEntity<Deseo> agregarDeseo(@PathVariable Long idProducto) {
		return ResponseEntity.ok(deseoService.agregarDeseo(idProducto));
	}

	@DeleteMapping("/{idProducto}")
	public ResponseEntity<Void> eliminarDeseo(@PathVariable Long idProducto) {
		deseoService.eliminarDeseo(idProducto);
		return ResponseEntity.noContent().build();
	}
}
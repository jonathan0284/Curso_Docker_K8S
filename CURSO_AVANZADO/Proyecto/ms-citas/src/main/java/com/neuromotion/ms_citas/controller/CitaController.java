package com.neuromotion.ms_citas.controller;

import com.neuromotion.ms_citas.model.Cita;
import com.neuromotion.ms_citas.mapper.CitasRequest;
import com.neuromotion.ms_citas.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody CitasRequest request) {
        Cita cita = citaService.guardarCita(request);
        return ResponseEntity.ok(cita);
    }

    @GetMapping
    public List<Cita> listarCitas() {
        return citaService.listarCitas();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<List<Cita>> obtenerCitasPorDniPaciente(@PathVariable String dni) {
        List<Cita> citas = citaService.listCitasPorDniPaciente(dni);
        if (citas != null && !citas.isEmpty()) {
            return ResponseEntity.ok(citas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

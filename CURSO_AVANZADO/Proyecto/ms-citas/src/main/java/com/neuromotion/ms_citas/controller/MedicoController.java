package com.neuromotion.ms_citas.controller;

import com.neuromotion.ms_citas.model.Medico;
import com.neuromotion.ms_citas.model.Usuario;
import com.neuromotion.ms_citas.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicoController {

    @Autowired
    private IMedicoService medicoService;

    @PostMapping("/medicos")
    public ResponseEntity<Medico> guardar(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.guardar(medico));
    }

    @GetMapping("/medicos")
    public List<Medico> listarUsuarios() {
        return medicoService.listarMedicos();
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Medico>  buscarMedicoByDni(@PathVariable String dni) {
        Medico medico = medicoService.obtenerMedicoByDni(dni);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/especialista/{especialidad}")
    public ResponseEntity<List<Medico>>  listarEspecialistas(@PathVariable String especialidad) {
        List<Medico> medicos = medicoService.listarMedicos(especialidad);
        if (medicos != null) {
            return ResponseEntity.ok(medicos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

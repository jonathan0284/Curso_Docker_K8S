package com.neuromotion.ms_citas.controller;

import com.neuromotion.ms_citas.dto.UsuarioDto;
import com.neuromotion.ms_citas.model.Usuario;
import com.neuromotion.ms_citas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuarios/{dni}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String dni) {
        Usuario usuario = usuarioService.obtenerUsuarioByDni(dni);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/pacientes", method = RequestMethod.GET)
    public List<UsuarioDto> listarPacientes() {
        return usuarioService.listarPacientes();
    }
}

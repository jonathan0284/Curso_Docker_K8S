package com.neuromotion.ms_citas.service.impl;

import com.neuromotion.ms_citas.dto.UsuarioDto;
import com.neuromotion.ms_citas.model.Usuario;
import com.neuromotion.ms_citas.repository.UsuarioRepository;
import com.neuromotion.ms_citas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioByDni(String dni) {
        return usuarioRepository.findByDni(dni).orElse(null);
    }

    @Override
    public List<UsuarioDto> listarPacientes() {
        List<UsuarioDto> lista = new ArrayList<>();
        listarUsuarios().forEach(usuario -> {
            lista.add(new UsuarioDto(usuario.getDni(),usuario.getNombre()));
        });
        return lista;
    }
}

package com.neuromotion.ms_citas.service;

import com.neuromotion.ms_citas.dto.UsuarioDto;
import com.neuromotion.ms_citas.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioByDni(String dni);
    List<UsuarioDto> listarPacientes();
}

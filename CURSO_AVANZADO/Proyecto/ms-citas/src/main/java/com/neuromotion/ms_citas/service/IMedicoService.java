package com.neuromotion.ms_citas.service;

import com.neuromotion.ms_citas.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    Medico guardar(Medico medico);
    Optional<Medico> buscarPorId(String id);
    List<Medico> listarMedicos();
    Medico obtenerMedicoByDni(String dni);
    List<Medico> listarMedicos(String especialidad);
}

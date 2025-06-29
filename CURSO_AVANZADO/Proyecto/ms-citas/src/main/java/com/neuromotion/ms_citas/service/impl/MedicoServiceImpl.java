package com.neuromotion.ms_citas.service.impl;


import com.neuromotion.ms_citas.model.Medico;
import com.neuromotion.ms_citas.repository.MedicoRepository;
import com.neuromotion.ms_citas.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Optional<Medico> buscarPorId(String id) {
        return medicoRepository.findById(id);
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico obtenerMedicoByDni(String dni) {
        return medicoRepository.findByDni(dni).orElse(null);
    }

    @Override
    public List<Medico> listarMedicos(String especialidad) {
        return medicoRepository.findByEspecialidad(especialidad);
    }
}

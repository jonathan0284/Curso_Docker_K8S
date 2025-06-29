package com.neuromotion.ms_citas.service.impl;

import com.neuromotion.ms_citas.dto.MedicoDto;
import com.neuromotion.ms_citas.dto.PacienteDto;
import com.neuromotion.ms_citas.mapper.CitasRequest;
import com.neuromotion.ms_citas.model.*;
import com.neuromotion.ms_citas.repository.CitaRepository;
import com.neuromotion.ms_citas.service.ICitaService;
import com.neuromotion.ms_citas.service.IMedicoService;
import com.neuromotion.ms_citas.service.IUsuarioService;
import com.neuromotion.ms_citas.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IMedicoService medicoService;

    @Override
    public Cita guardarCita(CitasRequest request) {

        // Buscar Paciente
        Usuario usuario = usuarioService.obtenerUsuarioByDni(request.getDniPaciente());
        // Buscar Medico
        Medico medico = medicoService.obtenerMedicoByDni(request.getDniMedico());

        Cita cita = new Cita();
        cita.setCodigoCita(Util.generateShortGUID());
        cita.setFechaHoraCita(request.getFechaHoraCita());
        cita.setMotivo(request.getMotivo());
        cita.setPaciente(transformPaciente(usuario));
        cita.setMedico(transformMedico(medico));
        cita.setLugar(request.getLugar());
        cita.setEstado("Creada");
        cita.setFecRegistro(new Date());

        return citaRepository.save(cita);

    }

    private MedicoDto transformMedico(Medico medico){
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setDni(medico.getDni());
        medicoDto.setNombre(medico.getNombre());
        medicoDto.setEspecialidad(medico.getEspecialidad());
        medicoDto.setCelular(medico.getCelular());
        return medicoDto;
    }

    private PacienteDto transformPaciente(Usuario usuario){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setDni(usuario.getDni());
        pacienteDto.setNombre(usuario.getNombre());
        pacienteDto.setDireccion(usuario.getDireccion());
        return pacienteDto;
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public List<Cita> listCitasPorDniPaciente(String dni) {
        return citaRepository.findByPacienteDni(dni);
    }
}

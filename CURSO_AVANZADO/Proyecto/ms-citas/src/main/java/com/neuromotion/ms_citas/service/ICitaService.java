package com.neuromotion.ms_citas.service;

import com.neuromotion.ms_citas.mapper.CitasRequest;
import com.neuromotion.ms_citas.model.Cita;

import java.util.List;

public interface ICitaService {
    Cita guardarCita(CitasRequest request);
    List<Cita> listarCitas();
    List<Cita> listCitasPorDniPaciente(String dni);
}

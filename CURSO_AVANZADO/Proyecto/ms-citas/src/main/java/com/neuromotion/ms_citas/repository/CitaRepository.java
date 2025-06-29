package com.neuromotion.ms_citas.repository;

import com.neuromotion.ms_citas.model.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {

    List<Cita> findByPacienteDni(String dni);
}

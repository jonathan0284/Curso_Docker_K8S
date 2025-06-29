package com.neuromotion.ms_citas.repository;

import com.neuromotion.ms_citas.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends MongoRepository<Medico, String> {
    Optional<Medico> findByDni(String dni);
    List<Medico> findByEspecialidad(String especialidad);
}

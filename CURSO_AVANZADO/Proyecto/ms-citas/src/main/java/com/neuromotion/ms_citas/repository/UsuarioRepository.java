package com.neuromotion.ms_citas.repository;


import com.neuromotion.ms_citas.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByDni(String dni);
}

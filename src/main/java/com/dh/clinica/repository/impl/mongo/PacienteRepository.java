package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
}

package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.mongo.PacienteMongo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositoryMongo extends MongoRepository<PacienteMongo, Integer> {
}

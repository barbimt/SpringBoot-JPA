package com.dh.clinica.repository.impl.mongo;

import com.dh.clinica.model.mongo.Odontologo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends MongoRepository<Odontologo, String> {
    /*
    @Query("SELECT o FROM odontologo o WHERE LOWER(o.nombre) LIKE('%' || LOWER(?1) || '%')")
    Optional<Odontologo> buscarOdontologoPorNombre(String nombre);*/
}

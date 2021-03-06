package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
    /*
    @Query("SELECT o FROM odontologo o WHERE LOWER(o.nombre) LIKE('%' || LOWER(?1) || '%')")
    Optional<Odontologo> buscarOdontologoPorNombre(String nombre);*/
}

package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.OdontologoDTO;
import com.dh.clinica.repository.impl.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
     OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO) {
        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        if(leerOdontologo(odontologoDTO.getId()) == null)
            throw  new ResourceNotFoundException("No se puede actualizar el odontólogo ID: " + odontologoDTO.getId());
        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException{
        if (id < 1)
            throw new BadRequestException("El id del odontólogo no puede negativo");
        if (!odontologoRepository.existsById(id))
            throw new ResourceNotFoundException("No existe ningún odontólogo con id: " + id);
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> leerTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String>procesarErrorNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
/*

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);

    }
/*
    public Odontologo buscarOdontologoPorNombre(String nombre){
        return odontologoRepository.buscarOdontologoPorNombre(nombre).get();
    }*/



}

package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.dto.OdontologoDTO;
import com.dh.clinica.repository.impl.OdontologoRepository;
import com.dh.clinica.service.IService.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
     OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        try {
            Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
            return odontologoRepository.save(odontologo);
        }catch(Exception e){
            throw  new BadRequestException("No se puede crear el odontólogo");
        }
    }

    @Override
    public Odontologo crearOdontologo(OdontologoDTO odontologoDTO)throws BadRequestException {
        try{
            return guardarOdontologo(odontologoDTO);
        }catch (Exception e){
            throw  new BadRequestException("No se puede crear el odontólogo");
        }
    }

    @Override
    public OdontologoDTO leerOdontologo(Integer id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        } else {
            throw new ResourceNotFoundException("El odontólogo con ID:" + id + " no existe");
        }
        return odontologoDTO;
    }

    @Override
    public Odontologo modificarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException, ResourceNotFoundException {
        if(leerOdontologo(odontologoDTO.getId()) == null)
            throw  new ResourceNotFoundException("No se puede actualizar el odontólogo ID: " + odontologoDTO.getId() + ", porque no existe");
        try {
            return guardarOdontologo(odontologoDTO);
        } catch(Exception e){
            throw  new BadRequestException("No se puede modificar el odontólogo");
        }
    }

    @Override
    public void eliminarOdontologo(Integer id) throws BadRequestException, ResourceNotFoundException{
        if (id < 1)
            throw new BadRequestException("El id del odontólogo no puede ser negativo");
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
}

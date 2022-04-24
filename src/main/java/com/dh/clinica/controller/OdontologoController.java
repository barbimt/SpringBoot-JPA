package com.dh.clinica.controller;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;

import com.dh.clinica.model.dto.OdontologoDTO;
import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
     OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        try {
            return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDTO));
        } catch(Exception e) {
            throw  new BadRequestException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException{
        try{
            return odontologoService.leerOdontologo(id);
        }catch (Exception e ){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }


    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException, ResourceNotFoundException {
        try{
            return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        try{
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontólogo con ID: " + id);
        }catch ( Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarTodos() {
        return ResponseEntity.ok(odontologoService.leerTodos());
    }


}

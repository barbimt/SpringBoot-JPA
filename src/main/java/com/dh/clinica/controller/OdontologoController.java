package com.dh.clinica.controller;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;

import com.dh.clinica.model.OdontologoDTO;
import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
     OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologoDTO));
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Integer id){

        return odontologoService.leerOdontologo(id);
    }


    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontólogo con ID: " + id);
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarTodos() {
        return ResponseEntity.ok(odontologoService.leerTodos());
    }

/*
    @GetMapping("buscarPorNombre/{nombre}")
    public ResponseEntity<Odontologo> traerOdontologoPorNombre(@PathVariable String nombre) {
        Odontologo odontologo = odontologoService.buscarOdontologoPorNombre(nombre);
        if (odontologo != null) {
            return ResponseEntity.ok(odontologo);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }*/

}

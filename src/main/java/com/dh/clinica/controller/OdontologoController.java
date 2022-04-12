package com.dh.clinica.controller;

import com.dh.clinica.model.Odontologo;

import com.dh.clinica.model.OdontologoDTO;
import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        ResponseEntity<Odontologo> response = null;
        if (odontologoDTO.getId() != null && odontologoService.leerOdontologo(odontologoDTO.getId()) != null)
            response = ResponseEntity.ok(odontologoService.modificarOdontologo(odontologoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id){
        ResponseEntity response = null;
        if(odontologoService.leerOdontologo(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            odontologoService.eliminarOdontologo(id);
            response= new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
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

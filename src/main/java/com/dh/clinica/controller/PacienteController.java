package com.dh.clinica.controller;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.PacienteDTO;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.crearPaciente(pacienteDTO));
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Integer id){
        return pacienteService.leerPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity<Paciente> response = null;

        if (pacienteDTO.getId() != null && pacienteService.leerPaciente(pacienteDTO.getId()) != null)
            response = ResponseEntity.ok(pacienteService.modificarPaciente(pacienteDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id){
        ResponseEntity response = null;
        if(pacienteService.leerPaciente(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            pacienteService.eliminarPaciente(id);
            response= new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.leerTodos());
    }
}

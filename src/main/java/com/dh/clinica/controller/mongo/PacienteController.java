package com.dh.clinica.controller.mongo;


import com.dh.clinica.model.mongo.Paciente;
import com.dh.clinica.repository.impl.mongo.PacienteRepository;
import com.dh.clinica.service.mongo.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> guardaPaciente (@RequestBody Paciente p){
        return ResponseEntity.ok(pacienteService.guardar(p));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listar());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable String id){
        ResponseEntity response = null;
        if(pacienteService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            pacienteService.eliminar(id);
            response= ResponseEntity.ok("SE ELIMINÓ EL ODONTÓLOGO CON ID " + id);
            //(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable String id){
        return pacienteService.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.editar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}

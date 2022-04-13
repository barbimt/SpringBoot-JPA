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
    private PacienteService pacienteServiceMongo;

    public PacienteController(PacienteService pacienteServiceMongo) {
        this.pacienteServiceMongo = pacienteServiceMongo;
    }

    @PostMapping
    public ResponseEntity<Paciente> guardaPaciente (@RequestBody Paciente p){
        try {
            Paciente paciente = pacienteServiceMongo.guardar(p);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Paciente> listarTodos(){
        return pacienteServiceMongo.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id){
        pacienteServiceMongo.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable String id){
        return pacienteServiceMongo.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificarOdontologo(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (paciente.getId() != null && pacienteServiceMongo.buscar(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteServiceMongo.editar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}

package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.PacienteMongo;
import com.dh.clinica.service.mongo.PacienteServiceMongo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteControllerMongo {
    private PacienteServiceMongo pacienteServiceMongo;

    public PacienteControllerMongo(PacienteServiceMongo pacienteServiceMongo) {
        this.pacienteServiceMongo = pacienteServiceMongo;
    }

    @PostMapping
    public PacienteMongo guardaPaciente (@RequestBody PacienteMongo p){
        return pacienteServiceMongo.guardar(p);
    }

    @GetMapping
    public List<PacienteMongo> listarTodos(){
        return pacienteServiceMongo.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        pacienteServiceMongo.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public PacienteMongo buscarPorId(@PathVariable Integer id){
        return pacienteServiceMongo.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<PacienteMongo> modificarOdontologo(@RequestBody PacienteMongo pacienteMongo) {
        ResponseEntity<PacienteMongo> response = null;
        if (pacienteMongo.getId() != null && pacienteServiceMongo.buscar(pacienteMongo.getId()) != null)
            response = ResponseEntity.ok(pacienteServiceMongo.editar(pacienteMongo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}

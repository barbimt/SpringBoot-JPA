package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.TurnoMongo;
import com.dh.clinica.service.mongo.TurnoServiceMongo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoControllerMongo {


    private TurnoServiceMongo turnoServiceMongo;

    public TurnoControllerMongo(TurnoServiceMongo turnoServiceMongo) {
        this.turnoServiceMongo = turnoServiceMongo;
    }

    @PostMapping
    public TurnoMongo guardarTurno (@RequestBody TurnoMongo t){
        return turnoServiceMongo.guardar(t);
    }

    @GetMapping
    public List<TurnoMongo> listarTodos(){
        return turnoServiceMongo.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        turnoServiceMongo.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public TurnoMongo buscarPorId(@PathVariable Integer id){
        return turnoServiceMongo.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<TurnoMongo> modificarOdontologo(@RequestBody TurnoMongo turnoMongo) {
        ResponseEntity<TurnoMongo> response = null;

        if (turnoMongo.getId() != null && turnoServiceMongo.buscar(turnoMongo.getId()) != null)
            response = ResponseEntity.ok(turnoServiceMongo.editar(turnoMongo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

}

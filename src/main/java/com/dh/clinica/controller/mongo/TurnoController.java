package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.Paciente;
import com.dh.clinica.model.mongo.Turno;
import com.dh.clinica.service.mongo.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno (@RequestBody Turno t){
        return ResponseEntity.ok(turnoService.guardar(t));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable String id){
        ResponseEntity response = null;
        if(turnoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            turnoService.eliminar(id);
            response= ResponseEntity.ok("SE ELIMINÓ EL ODONTÓLOGO CON ID " + id);
            //(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/{id}")
    public Turno buscarPorId(@PathVariable String id){
        return turnoService.buscar(id);
    }


    @PutMapping()
    public ResponseEntity<Turno> modificarTurno(@RequestBody Turno t) {
        ResponseEntity<Turno> response = null;
        if (t.getId() != null && turnoService.buscar(t.getId()) != null)
            response = ResponseEntity.ok(turnoService.editar(t));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

}

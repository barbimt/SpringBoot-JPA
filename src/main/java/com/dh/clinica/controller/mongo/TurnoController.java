package com.dh.clinica.controller.mongo;

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

    @Autowired
    private TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public Turno guardarTurno (@RequestBody Turno t){
        return turnoService.guardar(t);
    }

    @GetMapping
    public List<Turno> listarTodos(){
        return turnoService.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id){
        turnoService.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public Turno buscarPorId(@PathVariable String id){
        return turnoService.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<Turno> modificarOdontologo(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;

        if (turno.getId() != null && turnoService.buscar(turno.getId()) != null)
            response = ResponseEntity.ok(turnoService.editar(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

}

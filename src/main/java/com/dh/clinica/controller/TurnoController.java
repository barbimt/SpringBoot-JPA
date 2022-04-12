package com.dh.clinica.controller;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDTO turnoDTO) {
      //  turnoService.crearTurno(turnoDTO)
       //  ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(turnoService.crearTurno(turnoDTO));

    }

    @GetMapping("/{id}")
    public TurnoDTO buscarPorId(@PathVariable Integer id){
        return turnoService.leerTurno(id);
    }

    @PutMapping()
    public ResponseEntity<Turno> modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        ResponseEntity<Turno> response = null;

        if (turnoDTO.getId() != null && turnoService.leerTurno(turnoDTO.getId()) != null)
            response = ResponseEntity.ok(turnoService.modificarTurno(turnoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable Integer id){
        ResponseEntity response = null;
        if(turnoService.leerTurno(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            turnoService.eliminarTurno(id);
            response= ResponseEntity.ok("SE ELIMINÓ EL TURNO CON ID " + id);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> listarTodos() {
        return ResponseEntity.ok(turnoService.leerTodos());
    }


}

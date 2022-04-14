package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.Odontologo;
import com.dh.clinica.service.mongo.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @PostMapping
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo o ){
        return ResponseEntity.ok(odontologoService.guardar(o));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable String id){
        ResponseEntity response = null;
        if(odontologoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        else{
            odontologoService.eliminar(id);
            response= ResponseEntity.ok("SE ELIMINÓ EL ODONTÓLOGO CON ID " + id);
            //(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable String id){
        return odontologoService.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologoMongo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologoMongo.getId() != null && odontologoService.buscar(odontologoMongo.getId()) != null)
            response = ResponseEntity.ok(odontologoService.editar(odontologoMongo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
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

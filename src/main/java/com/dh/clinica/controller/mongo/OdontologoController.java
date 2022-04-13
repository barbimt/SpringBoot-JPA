package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.Odontologo;
import com.dh.clinica.service.mongo.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public Odontologo guardarOdontologo(@RequestBody Odontologo o){
        return odontologoService.guardar(o);
    }

    @GetMapping
    public List<Odontologo>listarTodos(){
        return odontologoService.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id){
        odontologoService.eliminar(id);
        return "eliminado";
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

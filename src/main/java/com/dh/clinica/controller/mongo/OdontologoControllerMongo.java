package com.dh.clinica.controller.mongo;

import com.dh.clinica.model.mongo.OdontologoMongo;
import com.dh.clinica.service.mongo.OdontologoServiceMongo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoControllerMongo {
    private OdontologoServiceMongo odontologoServiceMongo;

    public OdontologoControllerMongo(OdontologoServiceMongo odontologoServiceMongo) {
        this.odontologoServiceMongo = odontologoServiceMongo;
    }

    @PostMapping
    public OdontologoMongo guardarOdontologo(@RequestBody OdontologoMongo o){
        return odontologoServiceMongo.guardar(o);
    }

    @GetMapping
    public List<OdontologoMongo>listarTodos(){
        return odontologoServiceMongo.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        odontologoServiceMongo.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public OdontologoMongo buscarPorId(@PathVariable Integer id){
        return odontologoServiceMongo.buscar(id);
    }

    @PutMapping()
    public ResponseEntity<OdontologoMongo> modificarOdontologo(@RequestBody OdontologoMongo odontologoMongo) {
        ResponseEntity<OdontologoMongo> response = null;

        if (odontologoMongo.getId() != null && odontologoServiceMongo.buscar(odontologoMongo.getId()) != null)
            response = ResponseEntity.ok(odontologoServiceMongo.editar(odontologoMongo));
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

package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.OdontologoMongo;
import com.dh.clinica.model.mongo.PacienteMongo;
import com.dh.clinica.model.mongo.TurnoMongo;
import com.dh.clinica.repository.impl.mongo.PacienteRepositoryMongo;
import com.dh.clinica.repository.impl.mongo.TurnoRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceMongo {
    private TurnoRepositoryMongo turnoRepositoryMongo;

    public TurnoServiceMongo(TurnoRepositoryMongo turnoRepositoryMongo) {
        this.turnoRepositoryMongo = turnoRepositoryMongo;
    }

    public TurnoMongo guardar(TurnoMongo t){
        return turnoRepositoryMongo.save(t);
    }

    public List<TurnoMongo> listar(){
        return turnoRepositoryMongo.findAll();
    }

    public TurnoMongo buscar(Integer id){
        return turnoRepositoryMongo.findById(id).orElseGet(null);
    }

    public void eliminar(Integer id){
        turnoRepositoryMongo.deleteById(id);
    }

    public TurnoMongo editar(TurnoMongo turnoMongo){
        return turnoRepositoryMongo.insert(turnoMongo);
    }
}

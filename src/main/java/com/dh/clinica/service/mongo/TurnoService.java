package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.Turno;
import com.dh.clinica.repository.impl.mongo.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno t){
        return turnoRepository.save(t);
    }

    public List<Turno> listar(){
        return turnoRepository.findAll();
    }

    public Turno buscar(String id){
        return turnoRepository.findById(id).orElseGet(null);
    }

    public void eliminar(String id){
        turnoRepository.deleteById(id);
    }

    public Turno editar(Turno turno){
        return turnoRepository.insert(turno);
    }
}

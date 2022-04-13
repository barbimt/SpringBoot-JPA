package com.dh.clinica.service.mongo;

import com.dh.clinica.model.mongo.Odontologo;
import com.dh.clinica.repository.impl.mongo.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    // Constructor
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo o){
        return odontologoRepository.save(o);
    }

    public List<Odontologo> listar(){
        return odontologoRepository.findAll();
    }

    public Odontologo buscar(String id){
        return odontologoRepository.findById(id).orElseGet(null);
    }

    public void eliminar(String id){
        odontologoRepository.deleteById(id);
    }

    public Odontologo editar(Odontologo o){
        return odontologoRepository.save(o);
    }
}

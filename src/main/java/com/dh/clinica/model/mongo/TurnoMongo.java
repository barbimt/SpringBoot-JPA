package com.dh.clinica.model.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Time;
import java.util.Date;
@Document(collection = "turnos")
public class TurnoMongo {
    @Id
    private Integer id;
    private Date fecha;
    private Time hora;
    @DBRef
    private PacienteMongo paciente;
    @DBRef
    private OdontologoMongo odontologo;

    public TurnoMongo() {
    }


    public TurnoMongo(Date fecha, Time hora, PacienteMongo paciente, OdontologoMongo odontologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public PacienteMongo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteMongo paciente) {
        this.paciente = paciente;
    }

    public OdontologoMongo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoMongo odontologo) {
        this.odontologo = odontologo;
    }
}

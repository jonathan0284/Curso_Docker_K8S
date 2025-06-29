package com.neuromotion.ms_citas.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neuromotion.ms_citas.dto.LugarDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CitasRequest implements Serializable {

    private String dniPaciente;
    private String dniMedico;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaHoraCita;

    private String motivo;
    private LugarDto lugar;

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(String dniMedico) {
        this.dniMedico = dniMedico;
    }

    public Date getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(Date fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LugarDto getLugar() {
        return lugar;
    }

    public void setLugar(LugarDto lugar) {
        this.lugar = lugar;
    }
}

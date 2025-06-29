package com.neuromotion.ms_citas.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {
    private String id;
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;
    private String dniNombre;

    public UsuarioDto() {
    }

    public UsuarioDto(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.dniNombre = dni + "-" + nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDniNombre() {
        return dniNombre;
    }

    public void setDniNombre(String dniNombre) {
        this.dniNombre = dniNombre;
    }
}

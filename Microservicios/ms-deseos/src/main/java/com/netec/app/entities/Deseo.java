package com.netec.app.entities;

import java.time.LocalDateTime;

public class Deseo {

	private Long idProducto;
	private String nombre;
	private Double precio;
	private LocalDateTime fechaAgregado;

	// Constructor vacío
	public Deseo() {
	}

	// Constructor completo
	public Deseo(Long idProducto, String nombre, Double precio, LocalDateTime fechaAgregado) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaAgregado = fechaAgregado;
	}

	// Getters y Setters
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDateTime getFechaAgregado() {
		return fechaAgregado;
	}

	public void setFechaAgregado(LocalDateTime fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}
}

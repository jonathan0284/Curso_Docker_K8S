package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Deseo;

public interface IDeseoService {
	public List<Deseo> listarDeseos();

	public Deseo agregarDeseo(Long idProducto);

	public void eliminarDeseo(Long idProducto);
}
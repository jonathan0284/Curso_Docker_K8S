package com.netec.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.netec.app.entities.Deseo;
import com.netec.app.feign.ProductoFeignClient;

@Service
public class DeseoServiceImpl implements IDeseoService {

	private final ProductoFeignClient productoClient;
	private final List<Deseo> deseos = new ArrayList<>();

	public DeseoServiceImpl(ProductoFeignClient productoClient) {
		this.productoClient = productoClient;
	}

	@Override
	public List<Deseo> listarDeseos() {
		return deseos;
	}

	@Override
	public Deseo agregarDeseo(Long idProducto) {
		ProductoFeignClient.Producto producto = productoClient.obtenerProductoPorId(idProducto);
		Deseo nuevoDeseo = new Deseo(producto.getId(), producto.getNombre(), producto.getPrecio(), LocalDateTime.now());
		deseos.add(nuevoDeseo);
		return nuevoDeseo;
	}

	@Override
	public void eliminarDeseo(Long idProducto) {
		deseos.removeIf(deseo -> deseo.getIdProducto().equals(idProducto));
	}
}

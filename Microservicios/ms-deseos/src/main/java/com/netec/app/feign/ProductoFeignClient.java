package com.netec.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Observar como la URL apunta ya al microservicio contenedorizado
//@FeignClient(name = "ms-productos", url = "http://ms-productos:9081")
@FeignClient(name = "ms-productos")
public interface ProductoFeignClient {

	@GetMapping("/productos/{id}")
	Producto obtenerProductoPorId(@PathVariable Long id);

    // Member class
	class Producto {
		private Long id;
		private String nombre;
		private String descripcion;
		private Double precio;
		private Integer stock;

		// Getters y Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}
	}
}
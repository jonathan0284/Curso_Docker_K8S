package com.sunat.pe.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sunat.pe.app.entities.Evento;
import com.sunat.pe.app.repository.EventoRepository;

@Service
public class EventoServiceImpl implements IEventoService {

	private final EventoRepository eventoRepository;

	public EventoServiceImpl(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	@Override
	public List<Evento> listarTodos() {
		return eventoRepository.findAll();
	}

	@Override
	public Optional<Evento> obtenerPorId(Long id) {
		return eventoRepository.findById(id);
	}

	@Override
	public Evento guardar(Evento evento) {
		if (eventoRepository.existsByCodigo(evento.getCodigo())) {
			throw new IllegalArgumentException("El evento ya existe con ese codigo.");
		}
		if (eventoRepository.existsByNombre(evento.getNombre())) {
			throw new IllegalArgumentException("El evento ya existe con ese nombre.");
		}
		return eventoRepository.save(evento);
	}

	@Override
	public Evento actualizar(Long id, Evento eventoActualizado) {
		return eventoRepository.findById(id).map(evento -> {
			evento.setNombre(eventoActualizado.getNombre());
			evento.setDescripcion(eventoActualizado.getDescripcion());
			evento.setFecha(eventoActualizado.getFecha());
			evento.setUbicacion(eventoActualizado.getUbicacion());
			evento.setCapacidadMax(eventoActualizado.getCapacidadMax());
			return eventoRepository.save(evento);
		}).orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));
	}

	@Override
	public void eliminar(Long id) {
		eventoRepository.deleteById(id);
	}

	@Override
	public Optional<List<Evento>> obtenerPorCodigo(String codigo) {
	    return Optional.ofNullable(eventoRepository.findByCodigo(codigo));
	}

}
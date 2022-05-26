package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Reclamo;
import com.proyecto.repository.ReclamoRepository;

@Service
public class ReclamoServiceImpl implements ReclamoService {
	@Autowired
	private ReclamoRepository repository;

	@Override
	public Reclamo insertUpdateReclamo(Reclamo obj) {
		return repository.save(obj);
	}

	@Override
	public List<Reclamo> listReclamoForFilters(String descripcion, int estado, int idTipoReclamo, int idCliente) {
		return repository.listReclamoForFilters(descripcion, estado, idTipoReclamo, idCliente);
	}
	
}

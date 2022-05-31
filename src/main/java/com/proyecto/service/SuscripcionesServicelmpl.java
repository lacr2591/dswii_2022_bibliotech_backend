package com.proyecto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Marca;
import com.proyecto.entidad.Suscripciones;
import com.proyecto.repository.MarcaRepository;
import com.proyecto.repository.SuscripcionesRepository;

@Service
public class SuscripcionesServicelmpl implements SuscripcionesService {

	@Autowired
	private SuscripcionesRepository Repository;

	@Override
	public Suscripciones registraSuscripciones(Suscripciones obj) {
		return Repository.save(obj);
	}

	@Override
	public Suscripciones registraActualizaSuscripciones(Suscripciones obj) {
		return Repository.save(obj);
	}

	@Override
	public List<Suscripciones> listarSuscripciones() {
		return Repository.findAll();
	}

	@Override
	public Suscripciones obtenerPorId(int id) {
		return Repository.findFirstById(id);
	}

}

package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Marca;
import com.proyecto.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository Repository;

	@Override
	public List<Marca> listaMarca() {
		return Repository.findAll();
	}

	@Override
	public Marca registraMarca(Marca obj) {
		return Repository.save(obj);
	}

	@Override
	public Marca registraActualizaMarca(Marca obj) {
		return Repository.save(obj);
	}

	@Override
	public List<Marca> listaMarcaNombrePaisFecha(String nombre, int estado, int idPais, String fecInicio,
			String fecFin) {
		return Repository.listaMarcaNombrePaisFecha(nombre, estado, idPais, fecInicio, fecFin);
	}

}

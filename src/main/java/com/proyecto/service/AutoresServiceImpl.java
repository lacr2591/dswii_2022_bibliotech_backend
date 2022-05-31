package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Autores;
import com.proyecto.entidad.Categoria;
import com.proyecto.repository.AutoresRepository;

@Service
public class AutoresServiceImpl implements AutoresService {

	@Autowired
	private AutoresRepository repository;

	@Override
	public List<Autores> ListarAutores() {
		return repository.findAll();
	}

	@Override
	public Autores ObtenerAutoresPorID(int id) {
		return repository.findFirstById(id);
	}

}

package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> ListarCategorias() {
		return repository.findAll();
	}

	@Override
	public Categoria ObtenerCategoriaPorID(int id) {
		return repository.findFirstById(id);
	}



	

}

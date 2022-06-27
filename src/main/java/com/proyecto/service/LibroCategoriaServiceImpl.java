package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.LibroCategoria;
import com.proyecto.repository.LibroCategoriaRepository;

@Service
public class LibroCategoriaServiceImpl implements LibroCategoriaService {

	@Autowired
	private LibroCategoriaRepository repository;

	@Override
	public List<LibroCategoria> ListarCategorias() {
		return repository.findAll();
	}

	@Override
	public LibroCategoria ObtenerCategoriaPorID(int id) {
		return repository.findFirstById(id);
	}



	

}

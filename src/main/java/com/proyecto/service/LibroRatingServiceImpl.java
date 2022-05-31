package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.repository.LibroRatingRepository;

@Service
public class LibroRatingServiceImpl implements LibroRatingService {

	@Autowired
	private LibroRatingRepository repository;

	@Override
	public List<RatingLibro> ListarRatingsLibros() {
		return repository.findAll();
	}

	@Override
	public RatingLibro ObtenerRatingsLibroPorID(int id) {
		return repository.findFirstById(id);
	}
	
}

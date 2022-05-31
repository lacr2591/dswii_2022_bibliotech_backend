package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;

public interface LibroRatingService {

	public abstract List<RatingLibro> ListarRatingsLibros();

	public abstract RatingLibro ObtenerRatingsLibroPorID(int id);
}

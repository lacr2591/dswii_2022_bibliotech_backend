package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.RatingLibro;

public interface LibroRatingRepository extends JpaRepository<RatingLibro, Integer> {

	public abstract RatingLibro findFirstById(int id);
	
	public abstract List<RatingLibro> findAllByIdLibro(int idLibro);
	
}
	
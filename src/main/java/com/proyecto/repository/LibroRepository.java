package com.proyecto.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	Optional<Libro> findLibroById(int idLibro);
	Optional<Libro> findLibroByTitle(String title);
	public List<Libro>findByTitleLike(String title);

}

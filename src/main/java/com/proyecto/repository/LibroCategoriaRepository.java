package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.LibroCategoria;
import com.proyecto.entidad.RatingLibro;

public interface LibroCategoriaRepository extends JpaRepository<LibroCategoria, Integer> {

	
	public abstract LibroCategoria findFirstById(int id);
	public abstract LibroCategoria findAllById(int id);
	public abstract List<LibroCategoria> findAllByIdLibro(int idLibro);
	
}
	
package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	
	public abstract Categoria findFirstById(int id);
	
}
	
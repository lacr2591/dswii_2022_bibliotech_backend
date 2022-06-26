package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entidad.Autores;
import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
	public abstract Biblioteca findFirstById(int id);
}

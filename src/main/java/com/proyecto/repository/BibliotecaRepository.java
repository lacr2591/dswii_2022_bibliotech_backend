package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entidad.Autores;
import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
	public abstract Biblioteca findFirstById(int id);
	
	public abstract Biblioteca findFirstByIdLibro(int idLibro);
	
	public abstract List <Biblioteca> findByIdInstitucionAndEstado(int idInstitucion,boolean estado );
	
	public abstract List <Biblioteca> findAllByIdLibro(int idLibro );
	
	
}

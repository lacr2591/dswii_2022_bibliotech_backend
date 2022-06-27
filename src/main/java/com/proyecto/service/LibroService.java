package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.*;
import com.proyecto.model.LibroBiblioteca;
import com.proyecto.model.LibroModel;

public interface LibroService {

	Libro registraActualizaLibro(LibroBiblioteca libroBibl);

	public abstract boolean registrarLibro(LibroBiblioteca libroBibl);

	public abstract boolean actualizarLibro(LibroBiblioteca libroBibl);

	public abstract Libro findFirstById(Integer id);

	Libro findLibroByTitle(String title);

	List<Libro> findByTitleLike(String title);

	public abstract List<Libro> listaLibro();
	
	public abstract List<LibroModel> ListarLibrosxEstudiante(int idEstudiante);

}

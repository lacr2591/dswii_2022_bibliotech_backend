package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.*;
import com.proyecto.model.LibroBiblioteca;

public interface LibroService {
	
Libro registraActualizaLibro(LibroBiblioteca libroBibl);

boolean registrarLibro(LibroBiblioteca libroBibl);

boolean actualizarLibro(LibroBiblioteca libroBibl);

Libro findLibroById(Integer idUser);

Libro findLibroByTitle(String title);

List<Libro> findByTitleLike(String title);


}

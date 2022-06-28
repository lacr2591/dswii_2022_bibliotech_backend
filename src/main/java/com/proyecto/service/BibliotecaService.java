package com.proyecto.service;

import java.util.List;

import com.proyecto.model.LibroBiblioteca;
import com.proyecto.model.LibroModel;

public interface BibliotecaService {

	public abstract List<LibroModel> ListarLibro(String email);
	
	public abstract List<LibroBiblioteca> ListarLibroGeneral(String email);
	
	public abstract LibroModel DetalleLibro(int id);
}

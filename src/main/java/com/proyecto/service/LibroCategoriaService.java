package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.LibroCategoria;

public interface LibroCategoriaService {

	public abstract List<LibroCategoria> ListarCategorias();

	public abstract LibroCategoria ObtenerCategoriaPorID(int id);
}

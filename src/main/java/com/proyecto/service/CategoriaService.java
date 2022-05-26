package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;

public interface CategoriaService {

	public abstract List<Categoria> ListarCategorias();

	public abstract Categoria ObtenerCategoriaPorID(int id);
}

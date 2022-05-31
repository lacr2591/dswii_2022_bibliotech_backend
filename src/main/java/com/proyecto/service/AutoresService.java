package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Autores;

public interface AutoresService {

	public abstract List<Autores> ListarAutores();

	public abstract Autores ObtenerAutoresPorID(int id);
}

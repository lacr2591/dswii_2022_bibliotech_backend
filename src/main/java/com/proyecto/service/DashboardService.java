package com.proyecto.service;

import java.util.List;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.DashboardCategorias;


public interface DashboardService {

	public abstract DashboardCategorias GetCategoriasPrestamos();
	public abstract DashboardCategorias GetInteraccionesCategorias();
	public abstract DashboardCategorias GetLibrosRank();
}

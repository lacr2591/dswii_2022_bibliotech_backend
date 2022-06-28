package com.proyecto.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.DashboardCategorias;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.repository.DashboardRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private BibliotecaRepository repository;

	EntityManager em;

	@Override
	public DashboardCategorias GetCategoriasPrestamos() {
		DashboardRepository repository = new DashboardRepository();

		return repository.GetUSP_GetCategoriasLibrosDASH();
	}

	@Override
	public DashboardCategorias GetInteraccionesCategorias() {
		DashboardRepository repository = new DashboardRepository();

		return repository.GetUSP_GetInteraccionesCategoriasDASH();
	}

	@Override
	public DashboardCategorias GetLibrosRank() {
		DashboardRepository repository = new DashboardRepository();

		return repository.GetUSP_GetLibrosRankDASH();
	}

}

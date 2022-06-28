package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.entidad.DashboardCategorias;
import com.proyecto.model.LibroModel;
import com.proyecto.service.BibliotecaService;
import com.proyecto.service.DashboardService;
import com.proyecto.service.LibroService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Dashboard")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class DashboardController {


	@Autowired
	private DashboardService dashboardServie;


	@GetMapping("/GetCategoriasPrestamos")
	@ResponseBody
	public ResponseEntity<DashboardCategorias> GetCategoriasPrestamos() {

		return ResponseEntity.ok(dashboardServie.GetCategoriasPrestamos());
	}
	
	@GetMapping("/GetInteraccionesCategorias")
	@ResponseBody
	public ResponseEntity<DashboardCategorias> GetInteraccionesCategorias() {

		return ResponseEntity.ok(dashboardServie.GetInteraccionesCategorias());
	}

	
	@GetMapping("/GetLibrosRank")
	@ResponseBody
	public ResponseEntity<DashboardCategorias> GetLibrosRank() {

		return ResponseEntity.ok(dashboardServie.GetLibrosRank());
	}



}

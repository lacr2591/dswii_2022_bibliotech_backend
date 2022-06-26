package com.proyecto.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.proyecto.entidad.Libro;
import com.proyecto.model.*;
import com.proyecto.service.*;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	public LibroService getLibroService() {
		return libroService;
	}

	public void setLibroService(LibroService libroService) {
		this.libroService = libroService;
	}
	
	@PostMapping ("/libro")
	public boolean registrarLibro (@RequestBody LibroBiblioteca libroBibl)
	{
		return getLibroService().registrarLibro(libroBibl);
	}
	
	@PutMapping ("/libro/{id}")
	public boolean actualizarLibro (@RequestBody LibroBiblioteca libroBibl)
	{
		return getLibroService().actualizarLibro(libroBibl);
	}

}

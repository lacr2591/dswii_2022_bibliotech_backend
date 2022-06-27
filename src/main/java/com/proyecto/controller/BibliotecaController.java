package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.LibroBiblioteca;
import com.proyecto.service.LibroService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/biblioteca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class BibliotecaController {
	
	@Autowired
	private LibroService libroService;
	
	@PostMapping ("/RegistrarLibroBiblioteca")
	@ResponseBody
	public boolean registrarLibro (@RequestBody LibroBiblioteca libroBibl)
	{
		return libroService.registrarLibro(libroBibl);
	}
	
	
	@PutMapping ("/ActualizarLibroBiblioteca")
	@ResponseBody
	public boolean actualizarLibro (@RequestBody LibroBiblioteca libroBibl)
	{
		return libroService.actualizarLibro(libroBibl);
	}
			
}

package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.LibroBiblioteca;
import com.proyecto.model.LibroModel;
import com.proyecto.service.BibliotecaService;
import com.proyecto.service.LibroService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Biblioteca")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class BibliotecaController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
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
	
	@GetMapping("/ListarLibrosBiblioteca")
	@ResponseBody
	public ResponseEntity<List<LibroModel>> ListarLibrosBiblioteca(@RequestParam   String email ) {
		return ResponseEntity.ok(bibliotecaService.ListarLibro(email));
	}
	
	//DEBE DEVOLVER NULO 
	@GetMapping("/ListarLibrosGeneral")
	@ResponseBody
	public ResponseEntity<List<LibroModel>> ListarLibrosGeneral(@RequestParam   String email ) {
		return ResponseEntity.ok(bibliotecaService.ListarLibroGeneral(email));
	}	
	
	//NO FUNCIONA BIEN
	@GetMapping("/ListarLibrosDetalle")
	@ResponseBody
	public ResponseEntity<List<LibroModel>> ListarLibrosDetalle(@RequestParam   int id  ) {
		return ResponseEntity.ok(bibliotecaService.ListarLibroDetalle(id));
	}	
	
	
			
}

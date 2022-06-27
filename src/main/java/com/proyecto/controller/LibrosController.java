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
import com.proyecto.service.LibroService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Libros")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class LibrosController {

	@Autowired
	private LibroService libroService;

	@GetMapping("/ListarLibrosxEstudiante")
	@ResponseBody
	public ResponseEntity<List<LibroModel>> ListarLibrosxEstudiante(@RequestParam int idEstudiante) {
		
		return ResponseEntity.ok(libroService.ListarLibrosxEstudiante(idEstudiante));
	}

}

package com.proyecto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Biblioteca;
import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.entidad.Usuario;
import com.proyecto.model.Estudiante;
import com.proyecto.model.EstudianteDetalle;
import com.proyecto.repository.BibliotecaRepository;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.LibroRatingService;
import com.proyecto.service.UsuarioService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Instituciones")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class InstitucionesController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/AgregarRepresentante")
	@ResponseBody
	public ResponseEntity<Integer> AgregarEstudiante(@RequestBody EstudianteDetalle nuevoEstudiante) {
		int modificaciones = 0;
		try {

			modificaciones = usuarioService.CrearRepresentante(nuevoEstudiante);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(modificaciones);
	}
}

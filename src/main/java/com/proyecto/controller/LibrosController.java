package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.entidad.RatingLibro;
import com.proyecto.model.LibroModel;
import com.proyecto.service.BibliotecaService;
import com.proyecto.service.DashboardService;
import com.proyecto.service.LibroRatingService;
import com.proyecto.service.LibroService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/Libros")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class LibrosController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private LibroRatingService libroRatingService;

	@Autowired
	private DashboardService dashboardServie;

	@Autowired
	private BibliotecaService bibliotecaService;

	@GetMapping("/ListarLibrosxEstudiante")
	@ResponseBody
	public List<LibroModel> ListarLibrosxEstudiante(@RequestParam int idEstudiante) {

		return libroService.ListarLibrosxEstudiante(idEstudiante);
	}

	@GetMapping("/DetalleLibro")
	@ResponseBody
	public ResponseEntity<LibroModel> DetalleLibro(int idLibro) {
		return ResponseEntity.ok(bibliotecaService.DetalleLibro(idLibro));
	}

	@GetMapping("/ObtenerResenaLibro")
	@ResponseBody
	public ResponseEntity<RatingLibro> ObtenerResenaLibro(int idLibro, String email) {

		return ResponseEntity.ok(libroRatingService.ObtenerRatingsLibroIdLibroEmail(idLibro, email));
	}

	@PostMapping("/ResenarLibro")
	@ResponseBody
	public ResponseEntity<Boolean> ResenarLibro(String email, int idLibro, int rating, String resena) {

		return ResponseEntity.ok(libroRatingService.ResenarLibro(email, idLibro, rating, resena));
	}
}

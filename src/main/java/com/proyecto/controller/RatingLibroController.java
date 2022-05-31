package com.proyecto.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entidad.Categoria;
import com.proyecto.entidad.RatingLibro;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.LibroRatingService;
import com.proyecto.util.AppSettings;

@RestController
@RequestMapping("/api/ratingLibros")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RatingLibroController {
	@Autowired
	private LibroRatingService libroRatingService;

	@GetMapping("/listarRatingLibros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ListarCategorias() {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<RatingLibro> lista = libroRatingService.ListarRatingsLibros();
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("data", null);
				salida.put("mensaje", "No existen datos para mostrar");
			} else {
				salida.put("data", lista);
				salida.put("mensaje", "Existen " + lista.size() + " datos para mostrar");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se procesó: " + e.getMessage());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping("/obtenerRatingLibroPorId")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ObtenerCategoriaPorId(
			@RequestParam(name = "id", required = false, defaultValue = "-1") int id) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			RatingLibro obj = libroRatingService.ObtenerRatingsLibroPorID(id);
			
			if (obj==null) {
				salida.put("mensaje", "No existe datos para mostrar");
				salida.put("data", null);
			} else {
				salida.put("data", obj);
				salida.put("mensaje", "Se encontro una categoria");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se procesó: " + e.getMessage());
		}
		return ResponseEntity.ok(salida);

	}
}
